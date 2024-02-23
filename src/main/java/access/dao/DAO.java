package access.dao;

import java.util.List;

public abstract class DAO<T> {

	public abstract T consultar(int ID);

	public abstract T crear(T obj);

	public abstract T modificar(T obj);

	public abstract void eliminar(T obj);

	public abstract List<T> lista();

}
