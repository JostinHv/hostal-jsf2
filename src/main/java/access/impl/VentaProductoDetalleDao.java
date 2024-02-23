package access.impl;

import access.conection.HibernateUtil;
import access.interfaces.Dao;
import domain.entity.VentaProductoDetalle;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class VentaProductoDetalleDao implements Dao<VentaProductoDetalle> {

    @Override
    public void insertar(VentaProductoDetalle obj) {
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
    public void modificar(VentaProductoDetalle obj) {
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
    public void eliminar(VentaProductoDetalle obj) {
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
    public VentaProductoDetalle obtener(int id) {
        VentaProductoDetalle ventaProductoDetalle = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            ventaProductoDetalle = session.get(VentaProductoDetalle.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ventaProductoDetalle;
    }

    @Override
    public List<VentaProductoDetalle> obtenerTodos() {
        List<VentaProductoDetalle> ventaProductoDetalles = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            ventaProductoDetalles = session.createQuery("from VentaProductoDetalle").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ventaProductoDetalles;
    }
}
