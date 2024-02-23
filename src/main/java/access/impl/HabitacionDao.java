package access.impl;

import access.conection.HibernateUtil;
import access.interfaces.Dao;
import domain.entity.Habitacion;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HabitacionDao implements Dao<Habitacion> {

    @Override
    public void insertar(Habitacion obj) {
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
    public void modificar(Habitacion obj) {
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
    public void eliminar(Habitacion obj) {
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
    public Habitacion obtener(int id) {
        Habitacion habitacion = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            habitacion = session.get(Habitacion.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return habitacion;
    }

    @Override
    public List<Habitacion> obtenerTodos() {
        List<Habitacion> habitaciones = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            habitaciones = session.createQuery("from Habitacion").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return habitaciones;
    }
}