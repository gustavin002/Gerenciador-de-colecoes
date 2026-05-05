/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.atividade.gerenciadorDeColecoes.model;

public class ArmarioBean {
    
    private int idArmario;
    private String prateleira;
    private String item;

    public ArmarioBean() {
    }

    public ArmarioBean(int idArmario, String prateleira, String item) {
        this.idArmario = idArmario;
        this.prateleira = prateleira;
        this.item = item;
    }

    public int getIdArmario() {
        return idArmario;
    }

    public void setIdArmario(int idArmario) {
        this.idArmario = idArmario;
    }

    public String getPrateleira() {
        return prateleira;
    }

    public void setPrateleira(String prateleira) {
        this.prateleira = prateleira;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
    
    
}
