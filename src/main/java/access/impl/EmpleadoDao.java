package access.impl;

import access.conection.HibernateUtil;
import access.interfaces.Dao;
import domain.entity.Empleado;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import javax.persistence.Query;
import java.util.List;

public class EmpleadoDao implements Dao<Empleado> {

    @Override
    public void insertar(Empleado obj) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(obj);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void modificar(Empleado obj) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(obj);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Empleado obj) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(obj);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Empleado obtener(int id) {
        Empleado empleado = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            empleado = session.get(Empleado.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return empleado;
    }

    @Override
    public List<Empleado> obtenerTodos() {
        List<Empleado> empleados = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            empleados = session.createQuery("from Empleado").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return empleados;
    }
    public Empleado obtenerPorUsername(String username) {
        Empleado empleado = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("from Empleado where username = :username");
            query.setParameter("username", username);
            empleado = (Empleado) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return empleado;
    }
}