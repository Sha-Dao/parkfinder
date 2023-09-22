package br.com.ifba.authentication.service;

import br.com.ifba.cliente.model.Cliente;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class TokenService {
    private final String secretKey = "joaopedro"; // Sua chave secreta

    public String generateToken(Cliente cliente) {
        String token = Jwts.builder()
                .setIssuer("cliente")
                .setSubject(cliente.getEmail())
                .claim("id", cliente.getId())
                .setExpiration(Date.from(LocalDateTime.now()
                        .plusMinutes(10)
                        .toInstant(ZoneOffset.of("-03:00"))))
                .signWith(SignatureAlgorithm.HS256, "joaopedro")
                .compact();

        return token;
    }

    public String getSubject(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey("joaopedro")
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }
}
