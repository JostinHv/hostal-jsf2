package access.interfaces;

import java.util.List;

public interface Dao<T> {

    public void insertar(T obj);

    public void modificar(T obj);

    public void eliminar(T obj);

    public T obtener(int id);

    public List<T> obtenerTodos();
}