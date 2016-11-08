package com.ipn.mx.model.entities;
// Generated 8/11/2016 12:07:37 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Carrera generated by hbm2java
 */
public class Carrera  implements java.io.Serializable {


     private Integer idCarrera;
     private Centrodetrabajo centrodetrabajo;
     private String nombreCarrera;
     private Integer duracion;
     private Set<Usuario> usuarios = new HashSet<Usuario>(0);

    public Carrera() {
    }

	
    public Carrera(Centrodetrabajo centrodetrabajo) {
        this.centrodetrabajo = centrodetrabajo;
    }
    public Carrera(Centrodetrabajo centrodetrabajo, String nombreCarrera, Integer duracion, Set<Usuario> usuarios) {
       this.centrodetrabajo = centrodetrabajo;
       this.nombreCarrera = nombreCarrera;
       this.duracion = duracion;
       this.usuarios = usuarios;
    }
   
    public Integer getIdCarrera() {
        return this.idCarrera;
    }
    
    public void setIdCarrera(Integer idCarrera) {
        this.idCarrera = idCarrera;
    }
    public Centrodetrabajo getCentrodetrabajo() {
        return this.centrodetrabajo;
    }
    
    public void setCentrodetrabajo(Centrodetrabajo centrodetrabajo) {
        this.centrodetrabajo = centrodetrabajo;
    }
    public String getNombreCarrera() {
        return this.nombreCarrera;
    }
    
    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }
    public Integer getDuracion() {
        return this.duracion;
    }
    
    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }
    public Set<Usuario> getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }




}


