package access.dao.Imp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import access.conection.HibernateUtil;
import access.dao.DAO;

public class SQLAutorImp extends DAO<Autor> {

	@Override
	public Autor consultar(int ID) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Autor autor = session.get(Autor.class, ID);
		session.close();
		return autor;
	}

	@Override
	public Autor crear(Autor obj) {
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
	public Autor modificar(Autor obj) {
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
	public void eliminar(Autor obj) {
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
	public List<Autor> lista() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "FROM Autor";
		Query query = session.createQuery(hql);
		List<Autor> resultados = query.list();
		session.close();
		return resultados;
	}

}
