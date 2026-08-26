package com.amore_in_canto.amoerincantoX.service;

import com.amore_in_canto.amoerincantoX.domain.Usuario;
import com.amore_in_canto.amoerincantoX.domain.enums.UserRole;
import com.amore_in_canto.amoerincantoX.repository.UsuarioRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder){
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario cadastrar(Usuario usuario){

        //Usuario.builder().email(usuario.getEmail()).nome(usuario.getNome()).build();

        if(usuarioRepository.existsByEmail(usuario.getEmail())){
            throw new IllegalArgumentException("Email já cadastrado por outro usuario");
        }

        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuario.setRole(UserRole.USER);

        return usuarioRepository.save(usuario);
    }

    public List<Usuario> findByemail(){
        return usuarioRepository.findAll();
    }

}
