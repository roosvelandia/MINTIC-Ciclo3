/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.sprint2.mintiendaSB.Controlador;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import mintic.sprint2.mintiendaSB.modelo.Cliente;
import mintic.sprint2.mintiendaSB.modelo.ClienteDAO;



/**
 *
 * @author Carlos Beltrán
 */
public class Controlador_cliente extends HttpServlet {

    Cliente cliente = new Cliente();
    ClienteDAO clienteDao = new ClienteDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Clientes")) {
            switch (accion) {
                case "Listar":
                    request.setAttribute("clientes", clienteDao.getCliente());
                    request.setAttribute("clienteEdit", new Cliente());
                    break;
                case "Agregar":
                    int idCliente = Integer.parseInt(request.getParameter("txtId"));
                    String nombreCliente = request.getParameter("txtNombre");
                    String direccion = request.getParameter("txtDireccion");                    
                    String telefono = request.getParameter("txtTelefono");
                    String correo = request.getParameter("txtCorreo");
                    cliente.setIdCliente(idCliente);
                    cliente.setNombreCliente(nombreCliente);
                    cliente.setDireccion(direccion);
                    cliente.setTelefono(telefono);
                    cliente.setCorreo(correo);
                  clienteDao.agregarCliente(cliente);
                    request.getRequestDispatcher("Controlador_cliente?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    int ideu = Integer.valueOf(request.getParameter("id"));
                    Cliente cli = new Cliente();
                    cli = clienteDao.getClienteId(ideu);
                    request.setAttribute("clienteEdit", cli);
                break;
                case "Buscar":
                    int idb = Integer.parseInt(request.getParameter("txtLocalizador"));
                    Cliente clib = new Cliente();
                    clib = clienteDao.getClienteId(idb);
                    request.setAttribute("clienteEdit", clib);
                    break;        
                    
                case "Actualizar":
                    int idClientea = Integer.parseInt(request.getParameter("txtId"));
                    String nombreClientea = request.getParameter("txtNombre");
                    String direcciona = request.getParameter("txtDireccion");
                    String telefonoa = request.getParameter("txtTelefono");
                    String correoa = request.getParameter("txtCorreo");
                    
                    cliente.setIdCliente(idClientea);
                    cliente.setNombreCliente(nombreClientea);
                    cliente.setDireccion(direcciona);
                    cliente.setTelefono(telefonoa);
                    cliente.setCorreo(correoa);
                    clienteDao.actualizarCliente(cliente);
                    request.getRequestDispatcher("Controlador_cliente?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    int idClientee = Integer.valueOf(request.getParameter("id"));
                    clienteDao.eliminarCliente(idClientee);
                    request.getRequestDispatcher("Controlador_cliente?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("jsp/clientes.jsp").forward(request, response);
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

