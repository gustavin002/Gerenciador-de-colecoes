/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.atividade.gerenciadorDeColecoes.controller;


import com.atividade.gerenciadorDeColecoes.model.UsuarioBean;
import com.atividade.gerenciadorDeColecoes.service.TokenService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.atividade.gerenciadorDeColecoes.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private TokenService tokenService;

   @PostMapping("/registrar")
    public String registrar(@RequestBody UsuarioBean usuario) {
        usuarioService.registrar(usuario);
        return "Registrado com sucesso";
    }

    @PostMapping("/login")
    public String login(@RequestBody UsuarioBean user) {
        UsuarioBean usuario = usuarioService.login(user.getEmail(), user.getSenha());
        if(usuario.getEmail() != null){
            return tokenService.gerarToken(usuario.getEmail());
        }else{
            return "inválido";
        }
    }
    
}