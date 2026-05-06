/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.atividade.gerenciadorDeColecoes.repository;

import com.atividade.gerenciadorDeColecoes.model.UsuarioBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    
    public void registrar (UsuarioBean usuario){
        
        try{
            
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            
            stmt =  conn.prepareStatement("INSERT INTO usuarios (nome, senha, email) VALUES (?, ?, ?)");
            
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getEmail());
            
            stmt.executeUpdate();
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        
    }
    
    public UsuarioBean login (String email, String senha){
        UsuarioBean user = new UsuarioBean();
        
        try{
            Connection conn = Conexao.conectar();
            
            PreparedStatement stmt = null;
            ResultSet rs = null;
        
            stmt = conn.prepareStatement("SELECT * FROM usuarios WHERE usuarios.email = ? and usuarios.senha = ?");
            stmt.executeUpdate();
            
            if(rs.next()){
            user.setEmail(rs.getString("email"));
            user.setSenha(rs.getString("senha"));
            }
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }
    
}
