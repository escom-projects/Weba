package com.ipn.mx.controller.servlets;

import com.ipn.mx.model.dao.UsuarioDAO;
import com.ipn.mx.model.entities.Usuario;
import com.ipn.mx.utilities.Utilerias;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
public class AyudaServlet extends HttpServlet {

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
        String accion = request.getParameter("accion");
        if (accion.equals("forgotAccesDatos")) {
            processSendEmail(request, response);
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

    private void processSendEmail(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        List<Usuario> usuarios = new ArrayList<>();
        Utilerias correo = new Utilerias();
        correo.init();
        
        String emailUser = request.getParameter("email");
        
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = new Usuario();
        usuario.setEmail(emailUser);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            JsonObjectBuilder mensajeBuilder = Json.createObjectBuilder();
            try {
                usuarios = dao.findByEmail(usuario);
                if (usuarios.isEmpty()) {
                    mensajeBuilder.add("userNotRegistered", true);
                } else {
                    Usuario u = usuarios.get(0);
                    u.setNickUsuario(emailUser);
                    u.setClaveUsuario(u.getPaternoUsuario() + "@" + u.getMaternoUsuario());
                    dao.update(u);
                    String asunto = "Recuperacion de datos de acceso";
                    StringBuilder mensaje = new StringBuilder("");
                    mensaje.append("Sus datos de acceso son: ").append("<br>")
                            .append("<b>").append("Usuario: ").append("</b>").append("<u>").append(u.getNickUsuario()).append("</u>").append("<br/>")
                            .append("<b>").append("Contrase&ntilde;a: ").append("</b>").append("<u>").append(u.getClaveUsuario()).append("</u>").append("<br/>");
                    if (!correo.enviarMail(emailUser, asunto, mensaje.toString())) {
                        mensajeBuilder.add("emailNotSent", true);
                    } else {
                        mensajeBuilder.add("emailNotSent", false)
                                .add("info", "Informacion actualizada");
                    }
                }
            } catch(NullPointerException nul) {
                mensajeBuilder.add("nullPointerError", true);
            }
            out.print(mensajeBuilder.build());
            out.flush();
        }
    }

}
