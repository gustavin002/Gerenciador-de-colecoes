/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.atividade.gerenciadorDeColecoes.service;

import com.atividade.gerenciadorDeColecoes.model.UsuarioBean;
import com.atividade.gerenciadorDeColecoes.repository.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioDAO repository;
    
    public void registrar (UsuarioBean usuario){
        repository.registrar(usuario);
    }
    
    public UsuarioBean login (String email, String senha){
        
        if(!email.equals(senha)){
            throw new IllegalArgumentException("Senha ou Email Incorretos");
        }
        return repository.login(email, senha);
        
    }
    
}