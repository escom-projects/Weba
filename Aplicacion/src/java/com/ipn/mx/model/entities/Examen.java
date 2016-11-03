package com.ipn.mx.model.entities;
// Generated 2/11/2016 10:58:55 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Examen generated by hbm2java
 */
public class Examen  implements java.io.Serializable {


     private Integer idExamen;
     private Materias materias;
     private Date fecha;
     private Set calificacioneses = new HashSet(0);
     private Set preguntases = new HashSet(0);

    public Examen() {
    }

	
    public Examen(Materias materias) {
        this.materias = materias;
    }
    public Examen(Materias materias, Date fecha, Set calificacioneses, Set preguntases) {
       this.materias = materias;
       this.fecha = fecha;
       this.calificacioneses = calificacioneses;
       this.preguntases = preguntases;
    }
   
    public Integer getIdExamen() {
        return this.idExamen;
    }
    
    public void setIdExamen(Integer idExamen) {
        this.idExamen = idExamen;
    }
    public Materias getMaterias() {
        return this.materias;
    }
    
    public void setMaterias(Materias materias) {
        this.materias = materias;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Set getCalificacioneses() {
        return this.calificacioneses;
    }
    
    public void setCalificacioneses(Set calificacioneses) {
        this.calificacioneses = calificacioneses;
    }
    public Set getPreguntases() {
        return this.preguntases;
    }
    
    public void setPreguntases(Set preguntases) {
        this.preguntases = preguntases;
    }




}


