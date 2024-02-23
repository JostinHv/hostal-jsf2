package access.dao;

import access.dao.Imp.SQLAdministradorImp;
import access.dao.Imp.SQLAutorImp;
import access.dao.Imp.SQLCategoriaImp;
import access.dao.Imp.SQLLibroImp;
import access.dao.Imp.SQLReservaImp;
import access.dao.Imp.SQLUsuarioImp;
import domain.entity.Administrador;
import domain.entity.Autor;
import domain.entity.Categoria;
import domain.entity.Libro;
import domain.entity.Reserva;
import domain.entity.Usuario;

public class SQLDAOFactory extends AbstractDAOFactory {

	@Override
	public DAO<Usuario> getUsuarioDAO() {
		return new SQLUsuarioImp();
	}

	@Override
	public DAO<Libro> getLibroDAO() {
		return new SQLLibroImp();
	}

	@Override
	public DAO<Categoria> getCategoriaDAO() {
		return new SQLCategoriaImp();
	}

	@Override
	public DAO<Autor> getAutorDAO() {
		return new SQLAutorImp();
	}

	@Override
	public DAO<Reserva> getReservaDAO() {
		return new SQLReservaImp();
	}

	@Override
	public DAO<Administrador> getAdministradorDAO() {
		return new SQLAdministradorImp();
	}

}
