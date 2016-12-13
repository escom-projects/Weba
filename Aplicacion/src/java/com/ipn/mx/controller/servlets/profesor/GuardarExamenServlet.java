package com.ipn.mx.controller.servlets.profesor;

import com.ipn.mx.model.dao.ExamenDAO;
import com.ipn.mx.model.entities.Examen;
import com.ipn.mx.model.entities.Preguntas;
import com.ipn.mx.model.entities.Respuestas;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
public class GuardarExamenServlet extends HttpServlet {

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
        try {
            int total = Integer.parseInt(request.getParameter("total"));
            String[] formulario = request.getParameterValues("form[]");
            System.out.println("formulario llegado.");
            System.out.println("Total preguntas: " + total);
            ExamenDAO dao = new ExamenDAO();
            Examen examen = new Examen();
            Set<Preguntas> preguntas = new HashSet<>(0);
            examen.setTitulo(formulario[0]);
            for (int i = 1; i < formulario.length; i += 7) {
                for (int j = 0; j < 6; j++) {
                    
                }
                Preguntas pregunta = new Preguntas();
                Set<Respuestas> respuestas = new HashSet<>(0);
                Respuestas respuesta_1 = new Respuestas();
                Respuestas respuesta_2 = new Respuestas();
                Respuestas respuesta_3 = new Respuestas();
                Respuestas respuesta_4 = new Respuestas();
                pregunta.setPregunta(formulario[i]);
                respuesta_1.setRespuesta(formulario[i + 1]); respuesta_1.setPreguntas(pregunta); 
                respuesta_2.setRespuesta(formulario[i + 2]); respuesta_2.setPreguntas(pregunta);
                respuesta_3.setRespuesta(formulario[i + 5]); respuesta_3.setPreguntas(pregunta);
                respuesta_4.setRespuesta(formulario[i + 6]); respuesta_4.setPreguntas(pregunta);
                
                switch(formulario[i + 3].charAt(1)) {
                    case '1': 
                        respuesta_1.setRespuestaExamen("Correcta");
                        break;
                    case '2': 
                        respuesta_2.setRespuestaExamen("Correcta");
                        break;
                    case '3': 
                        respuesta_3.setRespuestaExamen("Correcta");
                        break;
                    case '4': 
                        respuesta_4.setRespuestaExamen("Correcta");
                        break;
                }
                
                respuestas.add(respuesta_1);
                respuestas.add(respuesta_2);
                respuestas.add(respuesta_3);
                respuestas.add(respuesta_4);
                preguntas.add(pregunta);
                pregunta.setExamen(examen);
            }
            examen.setPreguntases(preguntas);
            dao.guardar(examen);
        } catch(NullPointerException e) {
            System.out.println("variables no capturadas: " + e.toString());
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
