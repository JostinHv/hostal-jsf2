package domain.model;

import java.util.List;

public abstract class AbsCRUD<T> {

	public abstract List<T> lista();

	public abstract T crear(T obj);

	public abstract T consultar(int ID);

	public abstract T modificar(T obj);

	public abstract void eliminar(T obj);

}
