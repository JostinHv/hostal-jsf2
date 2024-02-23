package access.dao.Imp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import access.conection.HibernateUtil;
import access.dao.DAO;

public class SQLAdministradorImp extends DAO<Administrador> {

	
	@Override
	public Administrador consultar(int ID) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Administrador administrador = session.get(Administrador.class, ID);
		session.close();
		return administrador;
	}

	@Override
	public Administrador crear(Administrador obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Administrador modificar(Administrador obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Administrador obj) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Administrador> lista() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "FROM Administrador";
		Query query = session.createQuery(hql);
		List<Administrador> resultados = query.list();
		session.close();
		return resultados;
	}

}
