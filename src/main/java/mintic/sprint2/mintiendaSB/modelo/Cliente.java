/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.sprint2.mintiendaSB.modelo;

public class Cliente {
    private int idCliente;
    private String nombreCliente;
    private String direccion;
    private String telefono;
    private String correo;

    public Cliente() {
    }

    public Cliente(int idCliente, String nombreCliente, String direccion, String telefono,String correo) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nombreCliente=" + nombreCliente + ", direccion=" + direccion + ", telefono=" + telefono + ", correo=" + correo + '}';
    }

    
}

