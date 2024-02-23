package access.dao.Imp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import access.conection.HibernateUtil;
import access.dao.DAO;
import domain.entity.Reserva;

public class SQLReservaImp extends DAO<Reserva> {

	@Override
	public Reserva consultar(int ID) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Reserva reserva = session.get(Reserva.class, ID);
		session.close();
		return reserva;
	}

	@Override
	public Reserva crear(Reserva obj) {
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
	public Reserva modificar(Reserva obj) {
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
	public void eliminar(Reserva obj) {
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
	public List<Reserva> lista() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "FROM Reserva";
		Query query = session.createQuery(hql);
		List<Reserva> resultados = query.list();
		session.close();
		return resultados;
	}

}
