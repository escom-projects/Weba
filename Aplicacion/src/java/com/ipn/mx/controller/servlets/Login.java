package com.ipn.mx.controller.servlets;

import com.ipn.mx.model.dao.UsuarioDAO;
import com.ipn.mx.model.entities.Tipousuario;
import com.ipn.mx.model.entities.Usuario;
import com.ipn.mx.sessions.Sesion;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        login(request, response);
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

    private void login(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher vista = null;
        UsuarioDAO dao = new UsuarioDAO(); 
        Usuario usuario = new Usuario();
        String ruta;
        int tipo;
               
        String nickUsuario = request.getParameter("inputNick");
        String passUsuario = request.getParameter("inputPassword");

        usuario.setNickUsuario(nickUsuario);
        usuario.setClaveUsuario(passUsuario);
        
        Usuario readed = dao.Login(usuario).get(0); 
        Tipousuario k = dao.getTipoUsuario(readed).get(0);
        tipo = Integer.parseInt(k.getTipo());
        Sesion sesion = new Sesion();
        sesion.crearSesion(request, response, "usuario", nickUsuario);
        sesion.crearSesion(request, response, "clave", passUsuario);
        
        switch(tipo){
            case 0:
                //admin
                ruta = "jsp/admin/menu-admin.jsp";
            break;
            case 1:
                //profe
                ruta = "jsp/profesor/menu-profesor.jsp";
            break;
            case 2:
                //alumno
                ruta = "jsp/alumno/menu-alumno.jsp";
            break;
            default:
                //error
                ruta = "jsp/Error.jsp?CodeError=1";
            break;
        }
        try {
            vista = request.
                getRequestDispatcher(ruta);
            vista.forward(request, response);
        } catch (ServletException | IOException ex) {
            ex.printStackTrace();
        }
    }

}
