package com.ipn.mx.model.dao;

import com.ipn.mx.model.entities.Usuario;
import com.ipn.mx.utilities.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Usuario
 */
public class UsuarioDAO {
    public void create (Usuario u) {
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.getTransaction();
        try {
            transaccion.begin();
            sesion.save(u);
            transaccion.commit();
        } catch (HibernateException e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
        }
    }
    
    public void update (Usuario u) {
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
    
    public void delete (Usuario u) {
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.getTransaction();
        try {
            transaccion.begin();
            sesion.delete(u);
            transaccion.commit();
        } catch (HibernateException e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
        }
    }
    
    public Usuario read(Usuario u) {
        Usuario read = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.getTransaction();
        try {
            transaccion.begin();
            read = (Usuario) sesion.get(u.getClass(), u.getClaveUsuario());
            transaccion.commit();
        } catch (HibernateException e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
        }
        return read;
    }
    
    public List<Usuario> readAll () {
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.getTransaction();
        List<Usuario> lce = new ArrayList<>();
        try {
            transaccion.begin();
            Query query = sesion.createQuery("from Usuario");
            lce = query.list();
            transaccion.commit();
        } catch (HibernateException e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
        }
        return lce;
    }
}