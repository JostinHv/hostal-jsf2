package access.dao.Imp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import access.conection.HibernateUtil;
import access.dao.DAO;

public class SQLLibroImp extends DAO<Libro> {

	@Override
	public Libro consultar(int ID) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Libro libro = session.get(Libro.class, ID);
		session.close();
		return libro;
	}

	@Override
	public Libro crear(Libro obj) {
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
	public Libro modificar(Libro obj) {
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
	public void eliminar(Libro obj) {
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
	public List<Libro> lista() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "FROM Libro";
		Query query = session.createQuery(hql);
		List<Libro> resultados = query.list();
		session.close();
		return resultados;
	}

}
