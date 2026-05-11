/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.atividade.gerenciadorDeColecoes.controller;

import com.atividade.gerenciadorDeColecoes.model.ArmarioBean;
import com.atividade.gerenciadorDeColecoes.service.ArmarioService;
import com.atividade.gerenciadorDeColecoes.service.TokenService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArmarioController {
    
    @Autowired
    private ArmarioService service;
    
    @Autowired
    private TokenService tokenService;
    
    @GetMapping("/locais")
    public List<ArmarioBean> listarArmario(@RequestHeader("Authorization") String auth){
        // Remove o prefixo "Bearer " para obter apenas o token
        String token = auth.replace("Bearer ", "");
        
        if(tokenService.validarToken(token)){
            return service.listarArmario();
        } else {
        // Se o token não for válido, retorna null (o ideal seria retornar um erro HTTP)
        return null;
        
        }
    }
    
    @PostMapping("/itens")
    public String adicionarItem (@RequestBody ArmarioBean armario, @RequestHeader("Authorization") String auth){
        // Remove o prefixo "Bearer " para obter apenas o token
        String token = auth.replace("Bearer ", "");
        
        if(tokenService.validarToken(token)){
            service.adicionarItem(armario);
            return "Item adicionado com sucesso";
        } else {
        return null;
        }
    }
    
    @DeleteMapping("/itens/{idArmario}")
    public String deletarItem (@PathVariable int idArmario, @RequestHeader("Authorization") String auth){
    // Remove o prefixo "Bearer " para obter apenas o token
        String token = auth.replace("Bearer ", "");
        
        if(tokenService.validarToken(token)){
            service.deletarItem(idArmario);
            return "Deletado com sucesso";
        } else {
        return null;
        }
    }
    
}
