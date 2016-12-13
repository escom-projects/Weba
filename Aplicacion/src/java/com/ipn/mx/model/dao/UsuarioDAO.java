package com.ipn.mx.model.dao;

import com.ipn.mx.model.entities.Materias;
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
    
    public List<Object[]> findMateriasBytipoUsuario (Usuario usuario) {
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.getTransaction();
        List<Object[]> users = new ArrayList<>();
        String hql = "from Usuario as u join u.materias where u.nickUsuario =:nickUsuario and u.claveUsuario =:claveUsuario";
        try {
            transaccion.begin();
            Query q = sesion.createQuery(hql);
            q.setParameter("nickUsuario", usuario.getNickUsuario());
            q.setParameter("claveUsuario", usuario.getClaveUsuario());
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
    
    public List<Usuario> findByEmail(Usuario usuario) {
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.getTransaction();
        List<Usuario> users = new ArrayList<>();
        String hql = "from Usuario as u "
                + " where u.email =:email";
        try {
            transaccion.begin();
            Query q = sesion.createQuery(hql);
            q.setParameter("email", usuario.getEmail());
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
        Usuario usuario = new Usuario();
        usuario.setNickUsuario("alumno_alumno");
        usuario.setClaveUsuario("paterno@alumno");
        List<Object[]> readed = new ArrayList<>();
        try {
            readed = dao.findMateriasBytipoUsuario(usuario);
            if (readed.isEmpty()) {
                System.out.println("Lista vacia");
            } else {
                for (Object[] materias : readed) {
                    System.out.println("ID: " + ((Materias)materias[1]).getIdMaterias());
                    System.out.println("Nombre: " + ((Materias)materias[1]).getNombreMateria());
                    System.out.println("Creditos: " + ((Materias)materias[1]).getCreditos());
                }
                System.out.println("Lectura de datos finalizada!!!");
            }
        } catch(NullPointerException n) {
            System.out.println("No existen materias relacionadas al usuario." + n.toString());
        }
    }
}
