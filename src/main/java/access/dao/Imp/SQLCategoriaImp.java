package access.dao.Imp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import access.conection.HibernateUtil;
import access.dao.DAO;
import domain.entity.Categoria;

public class SQLCategoriaImp extends DAO<Categoria> {

	@Override
	public Categoria consultar(int ID) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Categoria categoria = session.get(Categoria.class, ID);
		session.close();
		return categoria;
	}

	@Override
	public Categoria crear(Categoria obj) {
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
	public Categoria modificar(Categoria obj) {
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
	public void eliminar(Categoria obj) {
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
	public List<Categoria> lista() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "FROM Categoria";
		Query query = session.createQuery(hql);
		List<Categoria> resultados = query.list();
		session.close();
		return resultados;
	}

}
