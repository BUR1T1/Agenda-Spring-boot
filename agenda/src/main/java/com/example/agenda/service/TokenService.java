package com.example.agenda.service;

import com.example.agenda.models.Acesso;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class TokenService {

    private static final java.security.Key KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    @Value("${api.security.token.secret}")
    private String secret;

    public String gerarToken(Acesso acesso) {
        return Jwts.builder()
                .setSubject(acesso.getUsername())
                .claim("role", acesso.getAuthorities())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(KEY) // Use a KEY aqui
                .compact();
    }

    public String getUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(KEY) // Use a KEY aqui também
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}