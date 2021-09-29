/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.sprint2.mintiendaSB.Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import mintic.sprint2.mintiendaSB.modelo.Proveedor;
import mintic.sprint2.mintiendaSB.modelo.ProveedorDAO;




/**
 *
 * @author Carlos Beltrán
 */
public class Controlador_proveedor extends HttpServlet {

    Proveedor proveedor = new Proveedor();
    ProveedorDAO proveedorDao = new ProveedorDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Proveedores")) {
            switch (accion) {
                case "Listar":
                    request.setAttribute("proveedores", proveedorDao.getProveedor());
                    request.setAttribute("proveedorEdit", new Proveedor());
                    break;
                case "Agregar":
                    int idProveedor = Integer.parseInt(request.getParameter("txtId"));
                    String nombreProveedor = request.getParameter("txtNombre");
                    String direccionProveedor = request.getParameter("txtDireccion");                    
                    String telefonoProveedor = request.getParameter("txtTelefono");
                    String ciudadProveedor = request.getParameter("txtCiudad");
                    proveedor.setNitproveedor(idProveedor);
                    proveedor.setNombre_proveedor(nombreProveedor);
                    proveedor.setDireccion_proveedor(direccionProveedor);
                    proveedor.setTelefono_proveedor(telefonoProveedor);
                    proveedor.setCiudad_proveedor(ciudadProveedor);
                    proveedorDao.agregarProveedor(proveedor);
                    request.getRequestDispatcher("Controlador_proveedor?menu=Proveedores&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    int ideu = Integer.valueOf(request.getParameter("id"));
                    Proveedor prov = new Proveedor();
                    prov = proveedorDao.getProveedorId(ideu);
                    request.setAttribute("proveedorEdit", prov);
                    break;
                case "Buscar":
                    int idb = Integer.parseInt(request.getParameter("txtLocalizador"));
                    Proveedor prob = new Proveedor();
                    prob = proveedorDao.getProveedorId(idb);
                    request.setAttribute("proveedorEdit",prob);
                    break; 
                case "Actualizar":
                    int idProveedora = Integer.parseInt(request.getParameter("txtId"));
                    String nombreProveedora = request.getParameter("txtNombre");
                    String direcciona = request.getParameter("txtDireccion");
                    String telefonoa = request.getParameter("txtTelefono");
                    String ciudada = request.getParameter("txtCiudad");
                    
                    proveedor.setNitproveedor(idProveedora);
                    proveedor.setNombre_proveedor(nombreProveedora);
                    proveedor.setDireccion_proveedor(direcciona);
                    proveedor.setTelefono_proveedor(telefonoa);
                    proveedor.setCiudad_proveedor(ciudada);
                    proveedorDao.actualizarProveedor(proveedor);
                    request.getRequestDispatcher("Controlador_proveedor?menu=Proveedores&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    int idProveedore = Integer.valueOf(request.getParameter("id"));
                    proveedorDao.eliminarProveedor(idProveedore);
                    request.getRequestDispatcher("Controlador_proveedor?menu=Proveedores&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("jsp/proveedores.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

