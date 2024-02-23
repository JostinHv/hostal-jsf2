package aplication;

import java.util.List;

import domain.entity.Usuario;
import domain.model.AbsCRUD;
import domain.model.UsuarioModel;

public class ServicioUsuario extends ServicioCRUD<Usuario> {
	private AbsCRUD<Usuario> modelo;

	public ServicioUsuario() {
		this.modelo = new UsuarioModel();
	}

	@Override
	public List<Usuario> lista() {
		return modelo.lista();
	}

	@Override
	public Usuario crear(Usuario obj) {
		return modelo.crear(obj);
	}

	@Override
	public Usuario consultar(int ID) {
		return modelo.consultar(ID);
	}

	@Override
	public Usuario modificar(Usuario obj) {
		return modelo.modificar(obj);
	}

	@Override
	public void eliminar(Usuario obj) {
		modelo.eliminar(obj);
	}

}
