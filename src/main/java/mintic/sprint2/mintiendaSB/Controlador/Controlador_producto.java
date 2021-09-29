/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.sprint2.mintiendaSB.Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mintic.sprint2.mintiendaSB.modelo.LectorCSV;
import mintic.sprint2.mintiendaSB.modelo.Productos;

/**
 *
 * @author User
 */
public class Controlador_producto extends HttpServlet {

    LectorCSV lectorCSV = new LectorCSV(',',' ');
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Productos")) {
            switch (accion) {
                case "Listar":
                    request.getRequestDispatcher("jsp/productos.jsp").forward(request, response); 
                    break;
                case "Cargar":
                    String nombre = request.getParameter("nombre");
                    List<Productos> productos = new ArrayList<Productos>();
                    System.out.println(nombre);
                    //productos = lectorCSV.LeerCSVSimple("C:\\PRUEBAS/ile.csv");
                    productos = lectorCSV.LeerCSVSimple(nombre);
                    request.setAttribute("productos",productos);
                    request.getRequestDispatcher("jsp/productos.jsp").forward(request, response);                    break;
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
