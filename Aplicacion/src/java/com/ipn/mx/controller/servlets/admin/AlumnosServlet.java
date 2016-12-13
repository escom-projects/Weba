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
public class AlumnosServlet extends HttpServlet {

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
        if (accion.equals("eliminar")) {
            procesarEliminacionAlumno(request, response);
        } else if (accion.equals("readAll")) {
            procesarLecturaAlumnos(request, response);
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

    private void procesarEliminacionAlumno(HttpServletRequest request, HttpServletResponse response) {
        long matricula = Long.parseLong(request.getParameter("id"));
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = new Usuario();
        usuario.setMatricula(matricula);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            JsonObjectBuilder messageBuilder = Json.createObjectBuilder();
            Usuario leido = dao.read(usuario);
            dao.delete(leido);
            messageBuilder.add("Estado", "OK");
            out.print(messageBuilder.build());
            out.flush();
        } catch (IOException ex) {
            System.out.println("Error de escritura en buffer de salida: " + ex.toString());
        }
    }

    private void procesarLecturaAlumnos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UsuarioDAO dao = new UsuarioDAO();
        List<Object[]> alumnos = new ArrayList<>();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            JsonObjectBuilder alumnoBuilder = Json.createObjectBuilder();
            JsonArrayBuilder arrayAlumnosBuilder = Json.createArrayBuilder();
            try {
                alumnos = dao.findBytipoUsuario(2);
                if (alumnos.isEmpty()) {
                    alumnoBuilder.add("status", "emptyArray");
                } else {
                    for (Object[] alumno : alumnos) {
                        JsonObjectBuilder atributosProfesoresBuilder = Json.createObjectBuilder();
                        atributosProfesoresBuilder.add("ID", ((Usuario)alumno[0]).getMatricula())
                            .add("nombre", ((Usuario)alumno[0]).getNombreUsuario())
                            .add("apellidos", ((Usuario)alumno[0]).getPaternoUsuario() + " " + ((Usuario)alumno[0]).getMaternoUsuario())
                            .add("correo", ((Usuario)alumno[0]).getEmail())
                            .add("nickUsuario", ((Usuario)alumno[0]).getNickUsuario())
                            .add("claveUsuario", ((Usuario)alumno[0]).getClaveUsuario());
                        arrayAlumnosBuilder.add(atributosProfesoresBuilder);
                    }
                    alumnoBuilder.add("listaAlumnos", arrayAlumnosBuilder)
                        .add("status", "full");
                }
            } catch (NullPointerException nul) {
                System.out.println("Error de null: " + nul.toString());
                alumnoBuilder.add("status", "error");
            }
            out.print(alumnoBuilder.build());
            out.flush();
        }
    }

}
