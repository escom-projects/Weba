package com.ipn.mx.controller.servlets.admin;

import com.ipn.mx.model.dao.MateriasDAO;
import com.ipn.mx.model.entities.Materias;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
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
public class cargarMaterias extends HttpServlet {

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
        MateriasDAO dao = new MateriasDAO();
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
