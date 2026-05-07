/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.atividade.gerenciadorDeColecoes.controller;


import com.atividade.gerenciadorDeColecoes.model.UsuarioBean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.atividade.gerenciadorDeColecoes.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

   @PostMapping("/registrar")
    public String registrar(@RequestBody UsuarioBean usuario) {
        usuarioService.registrar(usuario);
        return "Registrado com sucesso";
    }

    @PostMapping("/login")
    public String login(@RequestBody UsuarioBean login) {
        usuarioService.login(login.getEmail(),login.getSenha());
        return "Logado com sucesso";
    }
}