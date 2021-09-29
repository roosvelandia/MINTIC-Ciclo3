/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.sprint2.mintiendaSB.modelo;

public class Proveedor {
    private int nitproveedor;
    private String ciudad_proveedor;
    private String direccion_proveedor;
    private String telefono_proveedor;
    private String nombre_proveedor;
    
    public Proveedor(){
        
    }
    public Proveedor(int nitproveedor, String ciudad_proveedor, String direccion_proveedor, String telefono_proveedor, String nombre_proveedor) {
        this.nitproveedor = nitproveedor;
        this.ciudad_proveedor = ciudad_proveedor;
        this.direccion_proveedor = direccion_proveedor;
        this.telefono_proveedor = telefono_proveedor;
        this.nombre_proveedor = nombre_proveedor;
    }

    public int getNitproveedor() {
        return nitproveedor;
    }

    public void setNitproveedor(int nitproveedor) {
        this.nitproveedor = nitproveedor;
    }

    public String getCiudad_proveedor() {
        return ciudad_proveedor;
    }

    public void setCiudad_proveedor(String ciudad_proveedor) {
        this.ciudad_proveedor = ciudad_proveedor;
    }

    public String getDireccion_proveedor() {
        return direccion_proveedor;
    }

    public void setDireccion_proveedor(String direccion_proveedor) {
        this.direccion_proveedor = direccion_proveedor;
    }

    public String getTelefono_proveedor() {
        return telefono_proveedor;
    }

    public void setTelefono_proveedor(String telefono_proveedor) {
        this.telefono_proveedor = telefono_proveedor;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "nitproveedor=" + nitproveedor + ", ciudad_proveedor=" + ciudad_proveedor + ", direccion_proveedor=" + direccion_proveedor + ", telefono_proveedor=" + telefono_proveedor + ", nombre_proveedor=" + nombre_proveedor + '}';
    }

    
}

