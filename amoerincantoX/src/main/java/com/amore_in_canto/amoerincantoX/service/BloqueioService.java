package com.amore_in_canto.amoerincantoX.service;

import com.amore_in_canto.amoerincantoX.domain.Usuario;
import com.amore_in_canto.amoerincantoX.domain.Reserva;
import com.amore_in_canto.amoerincantoX.domain.Bloqueio;
import com.amore_in_canto.amoerincantoX.dto.BloqueioRequest;
import com.amore_in_canto.amoerincantoX.repository.ReservaRepository;
import com.amore_in_canto.amoerincantoX.repository.UsuarioRepository;
import com.amore_in_canto.amoerincantoX.repository.BloqueioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BloqueioService {

    private final BloqueioRepository bloqueioRepository;
    private final ReservaRepository reservaRepository;
    private final UsuarioRepository usuarioRepository;

    public BloqueioService(BloqueioRepository bloqueioRepository, ReservaRepository reservaRepository, UsuarioRepository usuarioRepository){
        this.bloqueioRepository = bloqueioRepository;
        this.reservaRepository = reservaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Bloqueio bloquearData(BloqueioRequest request){

        Usuario usuario = usuarioRepository.findById(request.getUsuarioId()).orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        Bloqueio bloqueio = Bloqueio.builder().usuario(usuario).startDate(request.getStartDate()).endDate(request.getEndDate()).motivo(request.getMotivo()).build();

        usuario.getBloqueios().add(bloqueio);

        return bloqueioRepository.save(bloqueio);
    }

    public List<Bloqueio> listarbloqueios() {
        return  bloqueioRepository.findAll();
    }
}
