package com.ipn.mx.controller.servlets;

import com.ipn.mx.model.dao.UsuarioDAO;
import com.ipn.mx.model.entities.Tipousuario;
import com.ipn.mx.model.entities.Usuario;
import com.ipn.mx.utilities.Utilerias;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import javax.servlet.RequestDispatcher;
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
        try {
            Utilerias correo = new Utilerias();
            DateFormat formatoFechaNacimiento = new SimpleDateFormat("yyyy-MM-dd");
            long matricula = Long.parseLong(request.getParameter("matricula"));
            String nombreUsuario = request.getParameter("nombre");
            String ap_paterno_usuario = request.getParameter("ap_paterno_usuario");
            String ap_materno_usuario = request.getParameter("ap_materno_usuario");
            String correo_usuario = request.getParameter("correo_usuario");
            String sexo = request.getParameter("sexo");
            String fechaNacimiento = request.getParameter("fechaNacimiento");
            String cp = request.getParameter("cp");
            String calle = request.getParameter("calle");
            String numero = request.getParameter("numero");
            String colonia = request.getParameter("colonia");
            String nick_usuario = request.getParameter("nombre_usuario");
            String clave_usuario = request.getParameter("clave_usuario");
            String rol_usuario = request.getParameter("tipo_usuario"); //Profesor - Alumno
            
            UsuarioDAO dao = new UsuarioDAO();
            HashSet<Tipousuario> tipos = new HashSet<>();
            Tipousuario tipo = new Tipousuario();
            if (rol_usuario.equals("Alumno")) {
                tipo.setTipo(2);
            } else if (rol_usuario.equals("Profesor")) {
                tipo.setTipo(1);
            }
            Usuario usuario = new Usuario(matricula, null, null,
                    nombreUsuario, ap_paterno_usuario, ap_materno_usuario,
                    null, calle, colonia, null, null,
                    null, correo_usuario, nick_usuario, clave_usuario,
                    new HashSet(), new HashSet());
            usuario.setFechaNacimiento(formatoFechaNacimiento.parse(fechaNacimiento));
            usuario.setNumero(Integer.valueOf(numero));
            usuario.setCodigoPostal(Long.valueOf(cp));
            usuario.setSexo(sexo.charAt(0));
            usuario.setTipousuarios(tipos);
            tipo.setUsuario(usuario);
            tipos.add(tipo);
            dao.guardar(usuario);
            if (!correo.enviarMail(correo_usuario, sexo, rol_usuario)) {
                
            } else {
                redireccionar(request, response);
            }
        } catch (ParseException ex) {
            System.out.println("Error de parseo de datos: " + ex.getMessage());
        }
        
    }

    private void redireccionar(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher vista = request.
                    getRequestDispatcher("jsp/ExitRegister.jsp?success=true");
            vista.forward(request, response);
        } catch (ServletException | IOException ex) {
            System.out.println("Ha ocurrido un error de redireccion de vista: " + ex.getMessage());
        }
    }

}
