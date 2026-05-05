/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.atividade.gerenciadorDeColecoes.service;

import com.atividade.gerenciadorDeColecoes.model.ArmarioBean;
import com.atividade.gerenciadorDeColecoes.repository.ArmarioDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArmarioService {
 
    @Autowired 
    private ArmarioDAO repository;
    
    public List<ArmarioBean> ListarArmario(){
        return repository.listarArmario();
    }
    
    public void adicionarItem (ArmarioBean armario){
        
        
        repository.adicionarItem(armario);
    }
    
    public void deletarItem (int idArmario){
        repository.deletarItem(idArmario);
    }
    
}
