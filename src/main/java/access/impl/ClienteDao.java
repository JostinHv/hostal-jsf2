package access.impl;

import access.conection.HibernateUtil;
import access.interfaces.Dao;
import domain.entity.Cliente;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ClienteDao implements Dao<Cliente> {

    @Override
    public void insertar(Cliente obj) {
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
    public void modificar(Cliente obj) {
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
    public void eliminar(Cliente obj) {
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
    public Cliente obtener(int id) {
        Cliente cliente = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            cliente = session.get(Cliente.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cliente;
    }

    public Cliente obtenerPorNombre(String nombre) {
        Cliente cliente = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Cliente WHERE nombre = :nombre";
            Query<Cliente> query = session.createQuery(hql, Cliente.class);
            query.setParameter("nombre", nombre);

            cliente = query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cliente;
    }

    @Override
    public List<Cliente> obtenerTodos() {
        List<Cliente> clientes = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            clientes = session.createQuery("from Cliente").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientes;
    }
}