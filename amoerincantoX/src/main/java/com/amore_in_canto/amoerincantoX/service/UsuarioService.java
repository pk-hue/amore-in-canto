package com.amore_in_canto.amoerincantoX.service;

import com.amore_in_canto.amoerincantoX.domain.Usuario;
import com.amore_in_canto.amoerincantoX.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario cadastrar(Usuario usuario){

        //Usuario.builder().email(usuario.getEmail()).nome(usuario.getNome()).build();

        if(usuarioRepository.existsByEmail(usuario.getEmail())){
            throw new IllegalArgumentException("Email já cadastrado");
        }
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> findByemail(){
        return usuarioRepository.findAll();
    }

}
