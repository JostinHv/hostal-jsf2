package access.impl;

import access.conection.HibernateUtil;
import access.interfaces.Dao;
import domain.entity.Reserva;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ReservaDao implements Dao<Reserva> {

    @Override
    public void insertar(Reserva obj) {
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
    public void modificar(Reserva obj) {
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
    public void eliminar(Reserva obj) {
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
    public Reserva obtener(int id) {
        Reserva reserva = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            reserva = session.get(Reserva.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reserva;
    }

    @Override
    public List<Reserva> obtenerTodos() {
        List<Reserva> reservas = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            reservas = session.createQuery("from Reserva").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservas;
    }
}