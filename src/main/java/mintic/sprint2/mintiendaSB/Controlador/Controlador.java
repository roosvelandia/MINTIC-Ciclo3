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
import mintic.sprint2.mintiendaSB.modelo.Usuario;
import mintic.sprint2.mintiendaSB.modelo.UsuarioDAO;


/**
 *
 * @author Carlos Beltrán
 */
public class Controlador extends HttpServlet {

    Usuario usuario = new Usuario();
    UsuarioDAO usuarioDao = new UsuarioDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Usuarios")) {
            switch (accion) {
                case "Listar":
                    String tipos [] = {"Administrador","Cliente"}; 
                    request.setAttribute("usuarios", usuarioDao.getUsuarios());
                    request.setAttribute("tipos", tipos);
                    request.setAttribute("usuarioEdit", new Usuario());
                    request.setAttribute("operacion", 1);
                    break;
                case "Agregar":
                    int idUsuario = Integer.parseInt(request.getParameter("txtId"));
                    String clave = request.getParameter("txtClave");
                    String nombreUsuario = request.getParameter("txtNombre");
                    String correo = request.getParameter("txtCorreo");
                    String tipoUsuario = request.getParameter("txtTipo");
                    usuario.setIdUsuario(idUsuario);
                    usuario.setClave(clave);
                    usuario.setCorreo(correo);
                    usuario.setNombreUsuario(nombreUsuario);
                    usuario.setTipoUsuario(tipoUsuario);
                    usuarioDao.agregarUsuario(usuario);
                    request.setAttribute("operacion", 0);
                    request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    int ideu = Integer.valueOf(request.getParameter("id"));
                    Usuario usu = new Usuario();
                    String [] categorias = {"Administrador","Cliente"};
                    usu = usuarioDao.getUsuarioId(ideu);
                    request.setAttribute("usuarioEdit", usu);
                    request.setAttribute("categorias", categorias);
                    request.setAttribute("operacion", 1);
                    break;
                case "Buscar":
                    System.out.println("Buscando" + Integer.parseInt(request.getParameter("txtLocalizador")));
                    int idb = Integer.parseInt(request.getParameter("txtLocalizador"));
                    Usuario usub = new Usuario();
                    String [] categoriasb = {"Administrador","Cliente"};
                    usub = usuarioDao.getUsuarioId(idb);
                    request.setAttribute("usuarioEdit", usub);
                    request.setAttribute("categorias", categoriasb);
                    request.setAttribute("operacion", 1);
                    break;
                case "Actualizar":
                    int idUsuarioa = Integer.parseInt(request.getParameter("txtId"));
                    String clavea = request.getParameter("txtClave");
                    String nombreUsuarioa = request.getParameter("txtNombre");
                    String correoa = request.getParameter("txtCorreo");
                    String tipoUsuarioa = request.getParameter("txtTipo");
                    usuario.setIdUsuario(idUsuarioa);
                    usuario.setClave(clavea);
                    usuario.setCorreo(correoa);
                    usuario.setNombreUsuario(nombreUsuarioa);
                    usuario.setTipoUsuario(tipoUsuarioa);
                    usuarioDao.actualizarUsuario(usuario);
                    request.setAttribute("operacion", 0);
                    request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    int idUsuarioe = Integer.valueOf(request.getParameter("id"));
                    usuarioDao.eliminarUsuario(idUsuarioe);
                    request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request, response);
                    request.setAttribute("operacion", 1);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("jsp/usuarios.jsp").forward(request, response);
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

