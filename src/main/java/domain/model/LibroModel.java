package domain.model;

import java.util.List;

import access.dao.AbstractDAOFactory;
import access.dao.DAO;
import access.dao.FactoryType;

public class LibroModel extends AbsCRUD<Libro> {
	private List<Libro> libros;
	private DAO<Libro> libroDAO;

	public LibroModel() {
		this.libroDAO = AbstractDAOFactory.getFactory(FactoryType.SQL_DAO_FACTORY).getLibroDAO();
		this.libros = libroDAO.lista();
	}

	@Override
	public List<Libro> lista() {
		this.libros = libroDAO.lista();
		return libros;
	}

	@Override
	public Libro crear(Libro obj) {
		return libroDAO.crear(obj);
	}

	@Override
	public Libro consultar(int ID) {
		return libroDAO.consultar(ID);
	}

	@Override
	public Libro modificar(Libro obj) {
		return libroDAO.modificar(obj);
	}

	@Override
	public void eliminar(Libro obj) {
		libroDAO.eliminar(obj);
	}

	public Libro reservarLibro(Libro obj) {
		obj.setEstado("Reservado");
		this.modificar(obj);
		return obj;
	}

	public Libro liberarLibro(Libro obj) {
		obj.setEstado("Disponible");
		this.modificar(obj);
		return obj;
	}

}
