package com.ipn.mx.sessions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Usuario
 */
public class Sesion { 	// Crea una clase publica llamada ClaseSimple
	public static String DATOS = "valor";	// Declaracion de una constante estatica 
												// de tipo cadena
												// Se utilizara como nombre de sesion

	/**
	 *  @param request: HttpServletRequest
	 *  @param response: HttpServletResponse
         *  @param attr
	 *  @param dato: String
	 */
	public void crearSesion (HttpServletRequest request, HttpServletResponse response, String attr, String dato) {
                DATOS = attr;
		HttpSession sesion = request.getSession(true); 	// Se asigna a una variable sesion 
                                                                // de tipo HttpSession una sesion nueva 
                                                                // para crear una sesion se pone como 
                                                                // parámetro true.
                sesion.setAttribute(DATOS, dato);   // Se asigna un nuevo atributo de sesion 
                                                    // con el nombre DATOS, con el valor dato de tipo 
                                                    // string
	}
        
        /**
	 *  @param request: HttpServletRequest
	 *  @param response: HttpServletResponse
         *  @param attr
	 *  @param dato: Object
	 */
	public void crearSesion (HttpServletRequest request, HttpServletResponse response, String attr, Object dato) {
                DATOS = attr;
		HttpSession sesion = request.getSession(true); 	// Se asigna a una variable sesion 
                                                                // de tipo HttpSession una sesion nueva 
                                                                // para crear una sesion se pone como 
                                                                // parámetro true.
                sesion.setAttribute(DATOS, dato);   // Se asigna un nuevo atributo de sesion 
                                                    // con el nombre DATOS, con el valor dato de tipo 
                                                    // string
	}

	/**
	 *  @param request: HttpServletRequest
	 *  @param response: HttpServletResponse
         *  @param attr
	 *  
	 */
	public void destruirSesion (HttpServletRequest request, HttpServletResponse response, String attr) {
		HttpSession sesion = request.getSession(true);	// Se asigna a una variable sesion 
                                                                // de tipo HttpSession una sesion nueva 
                                                                // para crear una sesion se pone como 
                                                                // parámetro true.
		sesion.removeAttribute(attr);
		if (sesion != null) {
			sesion.invalidate();
		}
	}

	/**
	 *  @param request: HttpServletRequest
	 *  @param response: HttpServletResponse
         *  @param attr
	 *  @return boolean
	 *  Metodo que verifica si una sesion es valida
	 */
	public boolean isSession (HttpServletRequest request, HttpServletResponse response, String attr) {
		HttpSession sesion = request.getSession(false);	// Se asigna a una variable sesion 
                                                                // de tipo HttpSession la sesion 
                                                                // existente, para no crearla se 
                                                                // pone como parámetro false.
		if (sesion == null) {	// verifica si la variable de sesion global es de tipo null
			return false;	// devuelve false
		} else {	//en caso contrario
			return (sesion.getAttribute(attr) != null);	// devuelve true si no es de tipo null 
                                                                        // la variable de sesion con 
                                                                        //atributo DATOS
		}
	}
        
}