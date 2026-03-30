package com.amore_in_canto.amoerincantoX.service;

import com.amore_in_canto.amoerincantoX.domain.Reserva;
import com.amore_in_canto.amoerincantoX.domain.Usuario;
import com.amore_in_canto.amoerincantoX.domain.enums.Status;
import com.amore_in_canto.amoerincantoX.repository.ReservaRepository;
import com.amore_in_canto.amoerincantoX.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservaService {
    private final ReservaRepository reservaRepository;
    private final UsuarioRepository usuarioRepository;

    public ReservaService (ReservaRepository reservaRepository ,UsuarioRepository usuarioRepository){
        this.usuarioRepository =  usuarioRepository;
        this.reservaRepository = reservaRepository;
    };

    public Reserva cadastrarReserva(Long usuarioId, LocalDate startDate, LocalDate endDate, Status status){

        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        Reserva reserva = Reserva.builder().usuario(usuario).startDate(startDate).endDate(endDate).status(status).build();

        usuario.getReservas().add(reserva);

        return  reservaRepository.save(reserva);
    };

    public List<Reserva> ListarReservas() {
        return reservaRepository.findAll();
    }
}
