package com.amore_in_canto.amoerincantoX.service;

import com.amore_in_canto.amoerincantoX.domain.Reserva;
import com.amore_in_canto.amoerincantoX.domain.Usuario;
import com.amore_in_canto.amoerincantoX.domain.enums.Status;
import com.amore_in_canto.amoerincantoX.repository.ReservaRepository;
import com.amore_in_canto.amoerincantoX.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ReservaService {
    private final ReservaRepository reservaRepository;
    private final UsuarioRepository usuarioRepository;

    public ReservaService (ReservaRepository reservaRepository ,UsuarioRepository usuarioRepository){
        this.usuarioRepository =  usuarioRepository;
        this.reservaRepository = reservaRepository;
    };

    public Reserva cadastrarReserva(String email){
        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Cliente não encontrado."));

        Reserva novaReserva = new  Reserva();
        novaReserva.setUsuario(usuario);
        novaReserva.setStartDate(LocalDate.now());
        novaReserva.setStatus(Status.REQUESTED);

        return  reservaRepository.save(novaReserva);
    };
}
