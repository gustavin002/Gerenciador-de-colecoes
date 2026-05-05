/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.atividade.gerenciadorDeColecoes.repository;

import com.atividade.gerenciadorDeColecoes.model.ArmarioBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.spi.DirStateFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ArmarioDAO {
    public List<ArmarioBean> listarArmario(){
        List<ArmarioBean> listar = new ArrayList();
        
        try{
            Connection conn = Conexao.conectar();
            
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("SELECT * FROM armarios");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                ArmarioBean armario = new ArmarioBean();
                armario.setIdArmario(rs.getInt("id_armario"));
                armario.setPrateleira(rs.getString("prateleira"));
                armario.setItem(rs.getString("item"));
            
                listar.add(armario);
            }
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        return listar;
    }
    
    public void adicionarItem (ArmarioBean armario){
        
        try{
            Connection conn = Conexao.conectar();
            
            PreparedStatement stmt = null;
            
            stmt = conn.prepareStatement("INSERT INTO armarios VALUES (?, ?, ?)");
            
            stmt.setString(2, armario.getPrateleira());
            stmt.setString(3, armario.getItem());
            
            stmt.executeUpdate();
            
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public void deletarItem (int idArmario){
        
        try{
            
            Connection conn = Conexao.conectar();
            
            PreparedStatement stmt = null;
            
            stmt = conn.prepareStatement("DELETE FROM armarios WHERE id_armario = ?");
            stmt.setInt(1, idArmario);
            
            stmt.executeUpdate();
            
        } catch (SQLException e){
            e.printStackTrace();
        }
    
    }
}
