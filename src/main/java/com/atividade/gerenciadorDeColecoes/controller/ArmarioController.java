/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.atividade.gerenciadorDeColecoes.controller;

import com.atividade.gerenciadorDeColecoes.model.ArmarioBean;
import com.atividade.gerenciadorDeColecoes.service.ArmarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArmarioController {
    
    @Autowired
    private ArmarioService service;
    
    @GetMapping("/locais")
    public List<ArmarioBean> listarArmario(){
        return service.listarArmario();
    }
    
    @PostMapping("/itens")
    public String adicionarItem (@RequestBody ArmarioBean armario){
        service.adicionarItem(armario);
        return "Item adicionado com sucesso";
    }
    
    @DeleteMapping("/itens/{idArmario}")
    public String deletarItem (@PathVariable int idArmario){
    service.deletarItem(idArmario);
    return "Item deletado com sucesso";
    }
    
} 
