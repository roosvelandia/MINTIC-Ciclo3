/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.sprint2.mintiendaSB.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Carlos Beltrán
 */
public class ClienteDAO extends Conexion{

    // Definir los Atributos. Capa de Datos. Se comunica con la BDs
    Connection con = null; // Hacer la conexion a la BDs
    Conexion cn = new Conexion();
    Statement stm = null; // Separa el espacio para construir un comando SQL
    ResultSet res = null; // Guarda el resultado de la consulta
    PreparedStatement ps = null;
    
    public List<Cliente> getCliente() {
        String sql = "SELECT * FROM cliente";

        List<Cliente> clientes = new ArrayList<>();

        try {   
            this.conectar();
            stm = this.getCon().createStatement();
            res = stm.executeQuery(sql);
            while (res.next()) { // Recorrer todo el ResultSet
                Cliente cli = new Cliente(); // Instanciamos un objeto tipo Usuario
                cli.setIdCliente(res.getInt(1));
                cli.setNombreCliente(res.getString(2));
                cli.setDireccion(res.getString(3));
                cli.setTelefono(res.getString(4));
                cli.setCorreo(res.getString(5));
                clientes.add(cli); // Agregarlo al ArrayList
            }
            stm.close(); // Cerrar toda la conexión a la BDs
            res.close();
        } catch (SQLException e) {
            System.err.println("Error:" + e);
        }
        
        return clientes; // Devuelve el ArrayList clientes
    }
    
    public boolean agregarCliente(Cliente cliente) {
        boolean registrar = false; // Permite identificar si ya existe el usuario
        boolean encontrado = false; // Encuentra un usuario con el correo Institucional
        String buscar = "SELECT * FROM usuario where cedula = " // Instrucción sql
                + cliente.getIdCliente(); // Para buscar un registro con el mismo id
        encontrado = buscar(buscar); // Ejecutamos el método con la consulta
        if(!encontrado){
            // La instrucción para insertar el registro
            String sql = "INSERT INTO cliente values (" + cliente.getIdCliente() + ",'" + cliente.getNombreCliente()
                    + "','" + cliente.getDireccion()+ "','" + cliente.getTelefono() + "','"
                    + cliente.getCorreo() + "')";
            try {
                con = this.getCon();
                stm = con.createStatement();
                stm.execute(sql);
                registrar = true;
                stm.close();
                //con.close();
            } catch (SQLException e) {
                System.out.println("Error: Clase UsuarioDao, método agregarUsuario");
                e.printStackTrace();
            }
        }

        return registrar;
    }

    public boolean buscar(String sql){
        boolean encontrado = false;
        con = this.getCon();
        try {
            stm = con.createStatement();
            res = stm.executeQuery(sql);
            while(res.next()){
                encontrado = true;
            }
        } catch (SQLException e) {
                System.out.println("Mensaje:"+e.getMessage());
                System.out.println("Estado:"+e.getSQLState());
                System.out.println("Codigo del error:"+e.getErrorCode());
                System.out.println("Error: Clase UsuarioDao, método agregarUsuario"+e.getMessage());
            }
        return encontrado;
    }

    public Cliente getClienteId(int id) {
        String sql = "SELECT * FROM cliente WHERE cedula=" + id;
        Cliente cli = new Cliente();
        try {
            con = this.getCon();
            ps = this.getCon().prepareStatement(sql);
            res = ps.executeQuery();
            while (res.next()) {
                cli.setIdCliente(res.getInt(1));
                cli.setNombreCliente(res.getString(2));
                cli.setDireccion(res.getString(3));
                cli.setTelefono(res.getString(4));
                cli.setCorreo(res.getString(5));
            }
            // cerramos el jdbc
            stm.close();
            res.close();
            //con.close();
        } catch (SQLException er) {
            System.err.println("Error:" + er);
        }
        return cli;
    }

    public boolean actualizarCliente(Cliente cliente) {
        boolean encontrado = false;
        boolean actualizar = false;
        String sql = "UPDATE cliente SET nombrecompleto = '" + cliente.getNombreCliente()
                + "', correo = '"  + cliente.getCorreo() + "', direccion='" + 
                cliente.getDireccion() + "'" + ", telefono = '" + cliente.getTelefono() + "'"
                + " WHERE cedula = " + cliente.getIdCliente();
        try {
            con = this.getCon();
            ps = con.prepareStatement(sql);
            ps.executeUpdate(sql);
            actualizar = true;
        } catch (SQLException e) {
            System.out.println("Error: Clase UsuarioDaoImple, método actualizar");
            e.printStackTrace();
        }
        return actualizar;
    }
 
    public boolean eliminarCliente(int id) {
        boolean encontrado = false;
        boolean eliminar = false;
        String buscar = "SELECT * FROM cliente WHERE cedula=" + id;
        encontrado = buscar(buscar);
        String sql = "DELETE FROM cliente WHERE cedula = " + id;
        if(encontrado){
            try {
                con = this.getCon();
                ps = con.prepareStatement(sql);
                ps.executeUpdate(sql);
                eliminar = true;
            } catch (SQLException e) {
                System.out.println("Error: Clase EstudianteDao, método eliminar");
                e.printStackTrace();
            }
        }
        return eliminar;
    }
    
}
