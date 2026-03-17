package com.amore_in_canto.amoerincantoX.controller;

import com.amore_in_canto.amoerincantoX.domain.Usuario;
import com.amore_in_canto.amoerincantoX.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController{

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    };

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario cadastrar(@RequestBody Usuario usuario){
        return usuarioService.cadastrar(usuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> findById(){
        List<Usuario> usuarios = usuarioService.findByemail();
        return ResponseEntity.ok(usuarios);
    }
}
