package domain.model;

import java.util.List;

import access.dao.AbstractDAOFactory;
import access.dao.DAO;
import access.dao.FactoryType;
import domain.entity.Categoria;

public class CategoriaModel extends AbsCRUD<Categoria> {
	private List<Categoria> categorias;
	private DAO<Categoria> categoriaDAO;

	public CategoriaModel() {
		this.categoriaDAO = AbstractDAOFactory.getFactory(FactoryType.SQL_DAO_FACTORY).getCategoriaDAO();
		this.categorias = categoriaDAO.lista();
	}

	@Override
	public List<Categoria> lista() {
		this.categorias = categoriaDAO.lista();
		return categorias;
	}

	@Override
	public Categoria crear(Categoria obj) {
		return categoriaDAO.crear(obj);
	}

	@Override
	public Categoria consultar(int ID) {
		return categoriaDAO.consultar(ID);
	}

	@Override
	public Categoria modificar(Categoria obj) {
		return categoriaDAO.modificar(obj);
	}

	@Override
	public void eliminar(Categoria obj) {
		categoriaDAO.eliminar(obj);
	}

}
