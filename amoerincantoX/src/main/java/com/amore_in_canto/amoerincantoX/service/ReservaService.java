package com.amore_in_canto.amoerincantoX.service;

import com.amore_in_canto.amoerincantoX.domain.Reserva;
import com.amore_in_canto.amoerincantoX.domain.Usuario;
import com.amore_in_canto.amoerincantoX.domain.enums.Status;
import com.amore_in_canto.amoerincantoX.dto.ReservaRequest;
import com.amore_in_canto.amoerincantoX.repository.BloqueioRepository;
import com.amore_in_canto.amoerincantoX.repository.ReservaRepository;
import com.amore_in_canto.amoerincantoX.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservaService {
    private final ReservaRepository reservaRepository;
    private final UsuarioRepository usuarioRepository;
    private final BloqueioRepository bloqueioRepository;

    public ReservaService (ReservaRepository reservaRepository ,UsuarioRepository usuarioRepository, BloqueioRepository bloqueioRepository) {
        this.usuarioRepository =  usuarioRepository;
        this.reservaRepository = reservaRepository;
        this.bloqueioRepository = bloqueioRepository;
    };

    public Reserva cadastrarReserva(ReservaRequest request){

        Usuario usuario = usuarioRepository.findById(request.getUsuarioId()).orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        if(request.getStartDate().isBefore(LocalDate.now())){
            throw new RuntimeException("Não é possível criar uma reserva para uma data no passado");
        };

        if(request.getStartDate().isAfter(request.getEndDate())){
            throw new RuntimeException("Data invalida.");
        }

        boolean dataBloqueada = bloqueioRepository.existsByPeriodo(request.getStartDate(), request.getEndDate());
        if(dataBloqueada){
            throw new RuntimeException("Esta data foi bloqueada pelo Administrador!");
        }

        List<Status> statusAtivo = List.of(Status.REQUESTED, Status.APPROVED);
        boolean dataJaBloqueada = reservaRepository.existsByPeriodoAndStatusIn(request.getStartDate(), request.getEndDate(), statusAtivo);
        if(dataJaBloqueada){
            throw new RuntimeException("Já exixte uma reserva solicitada ou aprovada nesta data!");
        }

        Reserva reserva = Reserva.builder().usuario(usuario).startDate(request.getStartDate()).endDate(request.getEndDate()).status(request.getStatus()).build();

        usuario.getReservas().add(reserva);

        return  reservaRepository.save(reserva);
    };

    public List<Reserva> ListarReservasPorUsuario(Long id) {
        if(!usuarioRepository.existsById(id)){
            throw new RuntimeException("Usuário não encontrado.");
        }
        return reservaRepository.findByUsuarioId(id);
    }

    public Reserva aprovarReserva(Long id){
        Reserva reserva = reservaRepository.findById(id).orElseThrow(() -> new RuntimeException("Reserva inexistente."));

        if(reserva.getStatus() != Status.REQUESTED){
            throw new RuntimeException("Apenas reservas com status REQUESTED podem ser aprovadas!");
        }

        boolean dataBloqueada = bloqueioRepository.existsByPeriodo(reserva.getStartDate(), reserva.getEndDate());
        if(dataBloqueada){
            throw new RuntimeException("Não é possível aprovar: Esta data foi bloqueada pelo Administrador!");
        }

        List<Status> statusAprovado = List.of(Status.APPROVED);
        boolean dataJaOcupada = reservaRepository.existsByPeriodoAndStatusIn(reserva.getStartDate(), reserva.getEndDate(), statusAprovado);
        if(dataJaOcupada){
            throw new RuntimeException("Não é possível aprovar: Já existe outra reserva APROVADA para este período.");
        }

        reserva.setStatus(Status.APPROVED);
        return  reservaRepository.save(reserva);
    };

    public Reserva recusarReserva(Long id){
        Reserva reserva = reservaRepository.findById(id).orElseThrow(() -> new RuntimeException("Reserva inexistente."));

        if(reserva.getStatus() != Status.REQUESTED){
            throw new RuntimeException("Apenas reservas com status REQUESTED podem ser recusadas!");
        }

        reserva.setStatus(Status.REJECTED);
        return  reservaRepository.save(reserva);
    }
}
