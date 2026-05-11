package com.amore_in_canto.amoerincantoX.controller;

import com.amore_in_canto.amoerincantoX.domain.Bloqueio;
import com.amore_in_canto.amoerincantoX.dto.BloqueioRequest;
import com.amore_in_canto.amoerincantoX.service.BloqueioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios/bloqueio")
public class BloqueioController {

    private final BloqueioService bloqueioService;

    public BloqueioController(BloqueioService bloqueioService){this.bloqueioService = bloqueioService;}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Bloqueio> criarBloqueio(@RequestBody BloqueioRequest request){
        Bloqueio bloqueio = bloqueioService.bloquearData(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(bloqueio);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Bloqueio>> listarBloqueioPorUsuario(@PathVariable Long usuarioId){
        List<Bloqueio> bloqueios = bloqueioService.listarBloqueioPorUsuario(usuarioId);
        return ResponseEntity.ok(bloqueios);
    }
}
