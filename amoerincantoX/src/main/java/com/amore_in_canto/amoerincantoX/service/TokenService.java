package com.amore_in_canto.amoerincantoX.service;

import com.amore_in_canto.amoerincantoX.domain.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class TokenService {
    private static final String SECRET_STRING = "AmoreInCantoX_MinhaChaveSuperSecretaParaOJWT_2026!";
    private final Key key = Keys.hmacShaKeyFor(SECRET_STRING.getBytes());

    private static final long EXPIRATION_TIME = 7200000; // 1 dia em milissegundos

    public String gerarToken(Usuario usuario){
        return Jwts.builder()
        .setSubject(usuario.getEmail())
        .claim("role", usuario.getRole()
        .name())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
        .signWith(key, SignatureAlgorithm.HS256)
        .compact();
    }

    public String validarToken (String token){
        try {
            return Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)
            .getBody()
            .getSubject();
        } catch (Exception e) {
            return null;
        }
    }
}
