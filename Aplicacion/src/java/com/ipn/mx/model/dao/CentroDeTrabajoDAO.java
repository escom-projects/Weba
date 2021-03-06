package com.ipn.mx.model.dao;

import com.ipn.mx.model.entities.Carrera;
import com.ipn.mx.model.entities.Centrodetrabajo;
import com.ipn.mx.utilities.HibernateUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Centrodetrabajo
 */
public class CentroDeTrabajoDAO {
    public void guardar (Centrodetrabajo ce) {
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.getTransaction();
        try {
            transaccion.begin();
            sesion.save(ce);
            transaccion.commit();
        } catch (HibernateException e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
        }
    }
    
    public void update (Centrodetrabajo u) {
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.getTransaction();
        try {
            transaccion.begin();
            sesion.saveOrUpdate(u);
            transaccion.commit();
        } catch (HibernateException e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
        }
    }
    
    public void delete (Centrodetrabajo ce) {
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.getTransaction();
        try {
            transaccion.begin();
            sesion.delete(ce);
            transaccion.commit();
        } catch (HibernateException e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
        }
    }
    
    public Centrodetrabajo read(Centrodetrabajo ce) {
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.getTransaction();
        try {
            transaccion.begin();
            ce = (Centrodetrabajo) sesion.get(ce.getClass(), ce.getIdcentrodetrabajo());
            transaccion.commit();
        } catch (HibernateException e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
        }
        return ce;
    }
    
    public List<Centrodetrabajo> readAll () {
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.getTransaction();
        List<Centrodetrabajo> lce = new ArrayList<>();
        try {
            transaccion.begin();
            Query query = sesion.createQuery("from Centrodetrabajo");
            lce = query.list();
            transaccion.commit();
        } catch (HibernateException e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
        }
        return lce;
    }
    
    public static void main(String[] args) {
        CentroDeTrabajoDAO dao = new CentroDeTrabajoDAO();
        HashSet<Carrera> carreras = new HashSet<>();
        Centrodetrabajo ce = new Centrodetrabajo("ESIME Azcapotzalco", new HashSet());
        Carrera ca1 = new Carrera(ce, "Ingeniería Mecánica", 120, new HashSet());
        Carrera ca2 = new Carrera(ce, "Ingeniería en Robótica Industrial", 119, new HashSet());
        Carrera ca3 = new Carrera(ce, "Ingeniería en Sistemas Automotrices", 120, new HashSet());
        carreras.add(ca1); carreras.add(ca2); carreras.add(ca3);
        ce.setCarreras(carreras);
        if (!carreras.isEmpty()) {
            ce.setCarreras(carreras);
            dao.guardar(ce);
        }
    }
}
