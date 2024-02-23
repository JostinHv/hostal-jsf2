package domain.model;

import java.util.List;

import access.dao.AbstractDAOFactory;
import access.dao.DAO;
import access.dao.FactoryType;

public class AutorModel extends AbsCRUD<Autor> {
	private List<Autor> autores;
	private DAO<Autor> autorDAO;

	public AutorModel() {
		this.autorDAO = AbstractDAOFactory.getFactory(FactoryType.SQL_DAO_FACTORY).getAutorDAO();
		this.autores = autorDAO.lista();
	}

	@Override
	public List<Autor> lista() {
		this.autores = autorDAO.lista();
		return autores;
	}

	@Override
	public Autor crear(Autor obj) {
		return autorDAO.crear(obj);
	}

	@Override
	public Autor consultar(int ID) {
		return autorDAO.consultar(ID);
	}

	@Override
	public Autor modificar(Autor obj) {
		return autorDAO.modificar(obj);
	}

	@Override
	public void eliminar(Autor obj) {
		autorDAO.eliminar(obj);
	}

}
