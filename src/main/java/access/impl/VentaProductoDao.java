package access.impl;

import access.conection.HibernateUtil;
import access.interfaces.Dao;
import domain.entity.VentaProducto;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class VentaProductoDao implements Dao<VentaProducto> {

    @Override
    public void insertar(VentaProducto obj) {
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
    public void modificar(VentaProducto obj) {
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
    public boolean eliminar(VentaProducto obj) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(obj);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public VentaProducto obtener(int id) {
        VentaProducto ventaProducto = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            ventaProducto = session.get(VentaProducto.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ventaProducto;
    }

    @Override
    public List<VentaProducto> obtenerTodos() {
        List<VentaProducto> ventaProductos = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            ventaProductos = session.createQuery("from VentaProducto").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ventaProductos;
    }
}