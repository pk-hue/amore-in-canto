package com.amore_in_canto.amoerincantoX.controller.config;

import com.amore_in_canto.amoerincantoX.repository.UsuarioRepository;
import com.amore_in_canto.amoerincantoX.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

//@Component
//public class SecurityFilter extends OncePerRequestFilter {
    
    //private final TokenService tokenService;
    //private final UsuarioRepository repository;

//}
