package com.ipn.mx.model.entities;
// Generated 13/12/2016 12:01:18 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Centrodetrabajo generated by hbm2java
 */
public class Centrodetrabajo  implements java.io.Serializable {


     private Integer idcentrodetrabajo;
     private String nombreCentroDeTrabajo;
     private Set<Carrera> carreras = new HashSet<Carrera>(0);

    public Centrodetrabajo() {
    }

    public Centrodetrabajo(String nombreCentroDeTrabajo, Set<Carrera> carreras) {
       this.nombreCentroDeTrabajo = nombreCentroDeTrabajo;
       this.carreras = carreras;
    }
   
    public Integer getIdcentrodetrabajo() {
        return this.idcentrodetrabajo;
    }
    
    public void setIdcentrodetrabajo(Integer idcentrodetrabajo) {
        this.idcentrodetrabajo = idcentrodetrabajo;
    }
    public String getNombreCentroDeTrabajo() {
        return this.nombreCentroDeTrabajo;
    }
    
    public void setNombreCentroDeTrabajo(String nombreCentroDeTrabajo) {
        this.nombreCentroDeTrabajo = nombreCentroDeTrabajo;
    }
    public Set<Carrera> getCarreras() {
        return this.carreras;
    }
    
    public void setCarreras(Set<Carrera> carreras) {
        this.carreras = carreras;
    }




}


