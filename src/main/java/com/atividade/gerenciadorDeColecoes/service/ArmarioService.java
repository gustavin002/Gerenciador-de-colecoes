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
    
    public List<ArmarioBean> listarArmario(){
        return repository.listarArmario();
    }
    
    public void adicionarItem (ArmarioBean armario){
       
        List<ArmarioBean> listar = repository.listarArmario();

        int totalNaPrateleira = 0;

        for (int contador = 0; contador < listar.size(); contador++) {

            ArmarioBean armarioAtual = listar.get(contador);

            if (armarioAtual.getPrateleira().equalsIgnoreCase(armario.getPrateleira())) {
                totalNaPrateleira++;
            }

            if (armarioAtual.getItem().equalsIgnoreCase(armario.getItem()) && armarioAtual.getPrateleira().equalsIgnoreCase(armario.getPrateleira())) {
                System.out.println("Já existe um item com esse nome nessa prateleira");
                return;
            }
        }

        if (totalNaPrateleira >= 10) {
            System.out.println("Local está lotado");
            return;
        }

    repository.adicionarItem(armario);
    }
    
    public void deletarItem (int idArmario){
        repository.deletarItem(idArmario);
    }
    
}
