package access.impl;

import access.conection.HibernateUtil;
import access.interfaces.Dao;
import domain.entity.Producto;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProductoDao implements Dao<Producto> {

    @Override
    public void insertar(Producto obj) {
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
    public void modificar(Producto obj) {
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
    public boolean eliminar(Producto obj) {
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
    public Producto obtener(int id) {
        Producto producto = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            producto = session.get(Producto.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return producto;
    }

    @Override
    public List<Producto> obtenerTodos() {
        List<Producto> productos = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            productos = session.createQuery("from Producto").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productos;
    }
}