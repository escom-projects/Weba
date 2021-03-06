package com.ipn.mx.controller.servlets.alumno;

import com.ipn.mx.model.dao.UsuarioDAO;
import com.ipn.mx.model.entities.Materias;
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
public class AlumnoServlet extends HttpServlet {

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
        if (accion.equals("findDisponibles")) {
            processFindExamenesDisponibles(request, response);
        } else if (accion.equals("verMisMaterias")) {
            processVerMisMaterias(request, response);
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

    private void processFindExamenesDisponibles(HttpServletRequest request, HttpServletResponse response) {
        
    }

    private void processVerMisMaterias(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = new Usuario();
        usuario.setNickUsuario((String) request.getSession().getAttribute("usuario"));
        usuario.setClaveUsuario((String) request.getSession().getAttribute("clave"));   
        List<Object[]> readed = new ArrayList<>();
        try (PrintWriter out = response.getWriter()) {
            JsonObjectBuilder mensajeBuilder = Json.createObjectBuilder();
            JsonArrayBuilder arrayMateriasBuilder = Json.createArrayBuilder();
            try {
                readed = dao.findMateriasBytipoUsuario(usuario);
                if (readed.isEmpty()) {
                    mensajeBuilder.add("status", "emptyArray");
                } else {
                    for (Object[] materias : readed) {
                        JsonObjectBuilder atributosProfesoresBuilder = Json.createObjectBuilder();
                        atributosProfesoresBuilder.add("ID", ((Materias)materias[1]).getIdMaterias())
                                .add("nombre", ((Materias)materias[1]).getNombreMateria())
                                .add("creditos", ((Materias)materias[1]).getCreditos());
                            
                        arrayMateriasBuilder.add(atributosProfesoresBuilder);
                    }
                    mensajeBuilder.add("listaMaterias", arrayMateriasBuilder)
                        .add("status", "full");
                }
            } catch(NullPointerException n) {
                mensajeBuilder.add("status", "nullArray");
            }
            out.print(mensajeBuilder.build());
            out.flush();
        }
    }

}
