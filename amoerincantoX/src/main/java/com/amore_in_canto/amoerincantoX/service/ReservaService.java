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

        if(request.getStartDate().isAfter(request.getEndDate())){
            throw new RuntimeException("Data invalida.");
        }

        boolean dataBloqueada = bloqueioRepository.existsByUsuarioAndPeriodo(usuario, request.getStartDate(), request.getEndDate());

        if(dataBloqueada){
            throw new RuntimeException("Esta data foi bloqueada pelo Administrador!");
        }

        Reserva reserva = Reserva.builder().usuario(usuario).startDate(request.getStartDate()).endDate(request.getEndDate()).status(request.getStatus()).build();

        usuario.getReservas().add(reserva);

        return  reservaRepository.save(reserva);
    };

    public List<Reserva> ListarReservas() {
        return reservaRepository.findAll();
    }
}
