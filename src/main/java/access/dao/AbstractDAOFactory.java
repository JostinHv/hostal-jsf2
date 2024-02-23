package access.dao;

import domain.entity.Reserva;
import domain.entity.Usuario;

public abstract class AbstractDAOFactory {

	public abstract DAO<Usuario> getUsuarioDAO();

	public abstract DAO<Libro> getLibroDAO();

	public abstract DAO<Categoria> getCategoriaDAO();

	public abstract DAO<Autor> getAutorDAO();

	public abstract DAO<Reserva> getReservaDAO();

	public abstract DAO<Administrador> getAdministradorDAO();

	public static AbstractDAOFactory getFactory(FactoryType type) {
		if (type.equals(FactoryType.SQL_DAO_FACTORY)) {
			return new SQLDAOFactory();
		}
		if (type.equals(FactoryType.MONGO_DAO_FACTORY)) {
			return new MongoDAOFactory();
		}
		return null;
	}

}
