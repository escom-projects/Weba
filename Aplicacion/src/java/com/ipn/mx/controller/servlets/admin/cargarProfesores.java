package com.ipn.mx.controller.servlets.admin;

import com.ipn.mx.model.dao.UsuarioDAO;
import com.ipn.mx.model.entities.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
public class cargarProfesores extends HttpServlet {

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
        UsuarioDAO dao = new UsuarioDAO();
        List<Object[]> usuarios = new ArrayList<>();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            JsonObjectBuilder usuariosBuilder = Json.createObjectBuilder();
            JsonObjectBuilder contenedorObject = Json.createObjectBuilder();
            JsonArrayBuilder arrayUsuariosBuilder = Json.createArrayBuilder();
            try {
                usuarios = dao.findBytipoUsuario(1);
                if (usuarios.isEmpty()) {
                    contenedorObject.add("status", "empty");
                } else {
                    contenedorObject.add("status", "full");
                    for (Object[] usuario : usuarios) {
                        usuariosBuilder.add("ID", ((Usuario) usuario[0]).getMatricula())
                            .add("nombre", ((Usuario) usuario[0]).getNombreUsuario())
                            .add("apPaterno", ((Usuario) usuario[0]).getPaternoUsuario())
                            .add("apMaterno", ((Usuario) usuario[0]).getMaternoUsuario())
                            .add("correo", ((Usuario) usuario[0]).getEmail())
                            .add("nickUsuario", ((Usuario) usuario[0]).getNickUsuario())
                            .add("claveUsuario", ((Usuario) usuario[0]).getClaveUsuario());
                        arrayUsuariosBuilder.add(usuariosBuilder);
                    }
                }
                contenedorObject.add("mensaje", arrayUsuariosBuilder);
            } catch(NullPointerException npe) {
                contenedorObject.add("status", "error");
            }
            out.print(contenedorObject.build());
            out.flush();
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
