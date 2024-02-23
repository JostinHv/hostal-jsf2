package aplication;

import java.util.List;

import domain.model.AbsCRUD;
import domain.model.AutorModel;

public class ServicioAutor extends ServicioCRUD<Autor> {

	private AbsCRUD<Autor> modelo;

	public ServicioAutor() {
		this.modelo = new AutorModel();
	}

	@Override
	public List<Autor> lista() {
		return modelo.lista();
	}

	@Override
	public Autor crear(Autor obj) {
		return modelo.crear(obj);
	}

	@Override
	public Autor consultar(int ID) {
		return modelo.consultar(ID);
	}

	@Override
	public Autor modificar(Autor obj) {
		return modelo.modificar(obj);
	}

	@Override
	public void eliminar(Autor obj) {
		modelo.eliminar(obj);
	}

}
