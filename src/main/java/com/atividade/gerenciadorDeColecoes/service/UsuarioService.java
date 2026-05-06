/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.atividade.gerenciadorDeColecoes.service;

import com.atividade.gerenciadorDeColecoes.repository.UsuarioDAO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;

public class UsuarioService {
    
    @Value("${api.security.token.secret}")
    private String secret;
    
    private SecretKey getSigningKey(){
        byte[] keyBytes = Decoders.BASE64.decode(this.secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    
    public String gerarToken(UsuarioDAO usuario) {
        return Jwts.builder()
        .subject(usuario.getLogin())
        .issuedAt(new Date())
        .expiration(new Date(System.currentTimeMillis() + 7200000))
        .signWith(getSigningKey())
        .compact();
    }
    
}
