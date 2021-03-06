package com.ipn.mx.controller.servlets.admin;

import com.ipn.mx.model.dao.CentroDeTrabajoDAO;
import com.ipn.mx.model.entities.Centrodetrabajo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
public class CentroDeTrabajoServlet extends HttpServlet {

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
        String centro_trabajo = request.getParameter("centro_trabajo");
        List<Centrodetrabajo> ces = new ArrayList<>();
        CentroDeTrabajoDAO dao = new CentroDeTrabajoDAO();
        Centrodetrabajo ce = new Centrodetrabajo();
        ce.setNombreCentroDeTrabajo(centro_trabajo);
        ce.setCarreras(new HashSet<>(0));
        
        dao.guardar(ce);
        
        try {
            ces = dao.readAll();
        } catch (NullPointerException e) {
            ces = null;
        }
        
        try {
            request.setAttribute("listaCES", ces);
            RequestDispatcher vista = request.
                getRequestDispatcher("jsp/admin/centrosDeTrabajo.jsp");
            vista.forward(request, response);
        } catch (ServletException | IOException ex) {
            System.out.println("Error de redireccion de pagina: " + ex.getMessage());
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
