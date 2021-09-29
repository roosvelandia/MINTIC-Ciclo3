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
public class ProveedorDAO extends Conexion{

    // Definir los Atributos. Capa de Datos. Se comunica con la BDs
    Connection con = null; // Hacer la conexion a la BDs
    Conexion cn = new Conexion();
    Statement stm = null; // Separa el espacio para construir un comando SQL
    ResultSet res = null; // Guarda el resultado de la consulta
    PreparedStatement ps = null;
    
    public List<Proveedor> getProveedor() {
        String sql = "SELECT * FROM proveedores";

        List<Proveedor> proveedores = new ArrayList<>();

        try {   
            this.conectar();
            stm = this.getCon().createStatement();
            res = stm.executeQuery(sql);
            while (res.next()) { // Recorrer todo el ResultSet
                Proveedor prov = new Proveedor(); // Instanciamos un objeto tipo Usuario
                prov.setNitproveedor(res.getInt(1));
                prov.setCiudad_proveedor(res.getString(2));
                prov.setDireccion_proveedor(res.getString(3));
                prov.setNombre_proveedor(res.getString(4));
                prov.setTelefono_proveedor(res.getString(5));
                proveedores.add(prov); // Agregarlo al ArrayList
            }
            stm.close(); // Cerrar toda la conexión a la BDs
            res.close();
        } catch (SQLException e) {
            System.err.println("Error:" + e);
        }
        
        return proveedores; // Devuelve el ArrayList clientes
    }
    
    public boolean agregarProveedor(Proveedor proveedor) {
        boolean registrar = false; // Permite identificar si ya existe el usuario
        boolean encontrado = false; // Encuentra un usuario con el correo Institucional
        String buscar = "SELECT * FROM proveedores where nitproveedor = " // Instrucción sql
                + proveedor.getNitproveedor(); // Para buscar un registro con el mismo id
        encontrado = buscar(buscar); // Ejecutamos el método con la consulta
        if(!encontrado){
            // La instrucción para insertar el registro
            String sql = "INSERT INTO proveedores values (" + proveedor.getNitproveedor()+ ",'" + proveedor.getCiudad_proveedor()
                    + "','" + proveedor.getDireccion_proveedor()+ "','" + proveedor.getNombre_proveedor()+ "','"
                    + proveedor.getTelefono_proveedor()+ "')";
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

    public Proveedor getProveedorId(int id) {
        String sql = "SELECT * FROM proveedores WHERE nitproveedor=" + id;
        Proveedor prov = new Proveedor();
        try {
            con = this.getCon();
            ps = this.getCon().prepareStatement(sql);
            res = ps.executeQuery();
            while (res.next()) {
                prov.setNitproveedor(res.getInt(1));
                prov.setCiudad_proveedor(res.getString(2));
                prov.setDireccion_proveedor(res.getString(3));
                prov.setNombre_proveedor(res.getString(4));
                prov.setTelefono_proveedor(res.getString(5));
            }
            // cerramos el jdbc
            stm.close();
            res.close();
            //con.close();
        } catch (SQLException er) {
            System.err.println("Error:" + er);
        }
        return prov;
    }

    public boolean actualizarProveedor(Proveedor proveedor) {
        boolean encontrado = false;
        boolean actualizar = false;
        String sql = "UPDATE proveedores SET ciudad_proveedor = '" + proveedor.getCiudad_proveedor()
                + "', direccion_proveedor = '"  + proveedor.getDireccion_proveedor()+ "', nombre_proveedor='" + 
                proveedor.getNombre_proveedor()+ "'" + ", telefono_proveedor = '" + proveedor.getTelefono_proveedor()+ "'"
                + " WHERE nitproveedor = " + proveedor.getNitproveedor();
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
 
    public boolean eliminarProveedor(int id) {
        boolean encontrado = false;
        boolean eliminar = false;
        String buscar = "SELECT * FROM proveedores WHERE nitproveedor=" + id;
        encontrado = buscar(buscar);
        String sql = "DELETE FROM proveedores WHERE nitproveedor = " + id;
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
