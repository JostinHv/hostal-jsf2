package domain.model;

import java.util.List;

import access.dao.AbstractDAOFactory;
import access.dao.DAO;
import access.dao.FactoryType;

public class AdministradorModel extends AbsCRUD<Administrador> {
	private List<Administrador> administradores;
	private DAO<Administrador> administradorDAO;

	public AdministradorModel() {
		this.administradorDAO = AbstractDAOFactory.getFactory(FactoryType.SQL_DAO_FACTORY).getAdministradorDAO();
		this.administradores = administradorDAO.lista();
	}

	@Override
	public List<Administrador> lista() {
		this.administradores = administradorDAO.lista();
		return administradores;
	}

	@Override
	public Administrador crear(Administrador obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Administrador consultar(int ID) {
		return administradorDAO.consultar(ID);
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

}
