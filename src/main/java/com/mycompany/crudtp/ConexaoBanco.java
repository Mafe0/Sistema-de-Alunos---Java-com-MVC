/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudtp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mafec
 */
public class ConexaoBanco {
    private static final String URL = "jdbc:mysql://localhost:3306/bd_crudtp";
    private static final String User = "root";
    private static final String Senha = "Mafe1824*";
    
    public static Connection conectar(){
     
        try{
            return DriverManager.getConnection(URL,User,Senha);
        }
        catch (SQLException e){
            throw new RuntimeException("Erro ao conectar ao banco", e);
        }
    }
}
