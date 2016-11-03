package com.ipn.mx.controller.servlets;

import com.ipn.mx.model.dao.UsuarioDAO;
import com.ipn.mx.model.entities.Roles;
import com.ipn.mx.model.entities.Tipousuario;
import com.ipn.mx.model.entities.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
public class Registro extends HttpServlet {

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
        registro(request, response);
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

    private void registro(HttpServletRequest request, HttpServletResponse response) {
        long matricula = Long.parseLong(request.getParameter("matricula"));
        String nombre = request.getParameter("nombre");
        String ap_paterno_usuario = request.getParameter("ap_paterno_usuario");
        String ap_materno_usuario = request.getParameter("ap_materno_usuario");
        String correo_usuario = request.getParameter("correo_usuario");
        String sexo = request.getParameter("sexo");
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        String cp = request.getParameter("cp");
        String calle = request.getParameter("calle");
        String numero = request.getParameter("numero");
        String colonia = request.getParameter("colonia");
        String nombre_usuario = request.getParameter("nombre_usuario");
        String clave_usuario = request.getParameter("clave_usuario");
        String rol_usuario = request.getParameter("tipo_usuario");
        
        UsuarioDAO dao = new UsuarioDAO();
        Roles roles = new Roles(rol_usuario, new HashSet(), new HashSet());
        Tipousuario tipo = new Tipousuario();
//        Usuario usuario = new Usuario(matricula, 
//                new HashSet(), roles, nombre_usuario, 
//                ap_materno_usuario, ap_materno_usuario, 
//                fechaNacimiento, calle, colonia, Long.valueOf(numero), 
//                Long.MIN_VALUE, Character.MAX_VALUE, 
//                correo_usuario, new HashSet(), tipo);
    }

}
