package aplication;

import java.util.List;

import domain.entity.Categoria;
import domain.model.AbsCRUD;
import domain.model.CategoriaModel;

public class ServicioCategoria extends ServicioCRUD<Categoria> {

	private AbsCRUD<Categoria> modelo;

	public ServicioCategoria() {
		this.modelo = new CategoriaModel();
	}

	@Override
	public List<Categoria> lista() {
		return modelo.lista();
	}

	@Override
	public Categoria crear(Categoria obj) {
		return modelo.crear(obj);
	}

	@Override
	public Categoria consultar(int ID) {
		return modelo.consultar(ID);
	}

	@Override
	public Categoria modificar(Categoria obj) {
		return modelo.modificar(obj);
	}

	@Override
	public void eliminar(Categoria obj) {
		modelo.eliminar(obj);
	}

}
