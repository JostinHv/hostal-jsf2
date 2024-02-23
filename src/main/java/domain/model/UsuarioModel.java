package domain.model;

import java.util.List;

import access.dao.AbstractDAOFactory;
import access.dao.DAO;
import access.dao.FactoryType;
import domain.entity.Usuario;

public class UsuarioModel extends AbsCRUD<Usuario> {
	private List<Usuario> usuarios;
	private DAO<Usuario> usuarioDAO;

	public UsuarioModel() {
		this.usuarioDAO = AbstractDAOFactory.getFactory(FactoryType.SQL_DAO_FACTORY).getUsuarioDAO();
		this.usuarios = usuarioDAO.lista();
	}

	@Override
	public List<Usuario> lista() {
		this.usuarios = usuarioDAO.lista();
		return usuarios;
	}

	@Override
	public Usuario crear(Usuario obj) {
		return usuarioDAO.crear(obj);
	}

	@Override
	public Usuario consultar(int ID) {
		return usuarioDAO.consultar(ID);
	}

	@Override
	public Usuario modificar(Usuario obj) {
		return usuarioDAO.modificar(obj);
	}

	@Override
	public void eliminar(Usuario obj) {
		usuarioDAO.eliminar(obj);
	}

}
