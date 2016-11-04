package com.ipn.mx.model.entities;
// Generated 4/11/2016 12:42:55 AM by Hibernate Tools 4.3.1


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
     private Set usuarios = new HashSet(0);

    public Carrera() {
    }

	
    public Carrera(Centrodetrabajo centrodetrabajo) {
        this.centrodetrabajo = centrodetrabajo;
    }
    public Carrera(Centrodetrabajo centrodetrabajo, String nombreCarrera, Integer duracion, Set usuarios) {
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
    public Set getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set usuarios) {
        this.usuarios = usuarios;
    }




}


