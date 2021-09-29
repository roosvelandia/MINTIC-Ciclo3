/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.sprint2.mintiendaSB.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    private Connection con;
    Statement consulta;
    public Connection conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&allowPublicKeyRetrieval=true", "root", "1234");
            consulta = con.createStatement();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return null;
    }
    protected void conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&allowPublicKeyRetrieval=true", "root", "1234");
            consulta = con.createStatement();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    protected void desconectar() {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Error :" + e);
        }
    }

    public Connection getCon() {
        return con;
    }
}

