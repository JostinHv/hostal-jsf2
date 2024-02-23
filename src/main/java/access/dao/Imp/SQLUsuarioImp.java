package access.dao.Imp;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import access.conection.HibernateUtil;
import access.dao.DAO;
import domain.entity.Cuenta;
import domain.entity.Usuario;

public class SQLUsuarioImp extends DAO<Usuario> {

	@Override
	public Usuario consultar(int ID) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Usuario usuario = session.get(Usuario.class, ID);
		session.close();
		return usuario;
	}

	@Override
	public Usuario crear(Usuario obj) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(obj);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return obj;
	}

	@Override
	public Usuario modificar(Usuario obj) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(obj);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return obj;
	}

	@Override
	public void eliminar(Usuario obj) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(obj);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public List<Usuario> lista() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "FROM Usuario";
		Query query = session.createQuery(hql);
		List<Usuario> resultados = query.list();
		session.close();
		return resultados;
	}

}
