package com.ipn.mx.controller.servlets.admin;

import com.ipn.mx.model.dao.MateriasDAO;
import com.ipn.mx.model.entities.Materias;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class MateriasServlet extends HttpServlet {

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
            procesarEliminacionMateria(request, response);
        } else if (accion.equals("agregar")) {
            procesarAgregarMateria(request, response);
        } else if (accion.equals("readAll")) {
            procesarLecturaMaterias(request, response);
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

    private void procesarEliminacionMateria(HttpServletRequest request, HttpServletResponse response) {
        MateriasDAO dao = new MateriasDAO();
        Integer id = new Integer(request.getParameter("id"));
        String nombreMateria = request.getParameter("nombre");
        Materias materia = new Materias();
        materia.setIdMaterias(id);
        materia.setNombreMateria(nombreMateria);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            JsonObjectBuilder messageBuilder = Json.createObjectBuilder();
            dao.delete(materia);
            messageBuilder.add("Estado", "OK");
            out.print(messageBuilder.build());
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(MateriasServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void procesarAgregarMateria(HttpServletRequest request, HttpServletResponse response) throws IOException {
        MateriasDAO dao = new MateriasDAO();
        Materias materia = new Materias();
        
        String nombreAsignatura = request.getParameter("asignature_name");
        int creditos = Integer.parseInt(request.getParameter("creditos_text"));
        
        materia.setNombreMateria(nombreAsignatura);
        materia.setCreditos(creditos);
        materia.setExamens(new HashSet<>());
        materia.setUsuarios(new HashSet<>());
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            JsonObjectBuilder messageBuilder = Json.createObjectBuilder();
            if (dao.guardar(materia)) {
                messageBuilder.add("Estado", "OK");
            } else {
                messageBuilder.add("Estado", "Failed");
            }
            out.print(messageBuilder.build());
            out.flush();
        }
    }

    private void procesarLecturaMaterias(HttpServletRequest request, HttpServletResponse response) throws IOException {
        MateriasDAO dao = new MateriasDAO();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            JsonObjectBuilder materiasBuilder = Json.createObjectBuilder();
            JsonArrayBuilder arrayMateriasBuilder = Json.createArrayBuilder();
            try {
                List<Materias> materias = dao.readAll();
                if (materias.isEmpty()) {
                    materiasBuilder.add("status", "empty");
                    arrayMateriasBuilder.add(materiasBuilder);
                } else {
                    materiasBuilder.add("status", "full");
                    for (Materias materia : materias) {
                        materiasBuilder.add("ID", materia.getIdMaterias())
                            .add("nombre", materia.getNombreMateria())
                            .add("creditos", materia.getCreditos());
                        arrayMateriasBuilder.add(materiasBuilder);
                    }
                }
            } catch(NullPointerException npe) {
                materiasBuilder.add("status", "error");
                arrayMateriasBuilder.add(materiasBuilder);
            }
            out.print(arrayMateriasBuilder.build());
            out.flush();
        }
    }

}
