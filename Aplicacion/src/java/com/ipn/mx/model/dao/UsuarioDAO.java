package com.ipn.mx.model.dao;

import com.ipn.mx.model.entities.Tipousuario;
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
    public void guardar (Usuario u) {
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
        List<Usuario> lu = new ArrayList<>();
        try {
            transaccion.begin();
            Query query = sesion.createQuery("from Usuario");
            lu = query.list();
            transaccion.commit();
        } catch (HibernateException e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
        }
        return lu;
    }
    
    public List<Usuario> Login(Usuario u) {
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.getTransaction();
        List<Usuario> users = new ArrayList<>();
        String hql = "from Usuario as u "
                + " where u.nickUsuario =:nickUsuario"
                + " and u.claveUsuario =:claveUsuario";
        try {
            transaccion.begin();
            Query q = sesion.createQuery(hql);
            q.setParameter("nickUsuario", u.getNickUsuario());
            q.setParameter("claveUsuario", u.getClaveUsuario());
            users = q.list();
            transaccion.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
        }
        return users;
    }
    
    public List<Tipousuario> getTipoUsuario(Usuario u) {
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.getTransaction();
        String hql = "from Tipousuario as t where t.usuario.matricula = :usuario";
        List<Tipousuario> tipos = new ArrayList<>();
        try {
            transaccion.begin();
            Query q = sesion.createQuery(hql);
            q.setParameter("usuario", u.getMatricula());
            tipos = q.list();
            transaccion.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
        }
        return tipos;
    }
    
    public List<Object[]> findBytipoUsuario (int type) {
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.getTransaction();
        List<Object[]> users = new ArrayList<>();
        String hql = "from Usuario as u " +
                    "join u.tipousuarios as t " +
                    "where t.tipo =:tipo";
        try {
            transaccion.begin();
            Query q = sesion.createQuery(hql);
            q.setParameter("tipo", type);
            users = q.list();
            transaccion.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
        }
        return users;
    }
    
    public static void main(String[] args) {
        UsuarioDAO dao = new UsuarioDAO();
        List<Object[]> usuarios = dao.findBytipoUsuario(1);
        for (Object[] usuario : usuarios) {
            System.out.println(((Usuario)usuario[0]).getNombreUsuario());
        }
    }
}
