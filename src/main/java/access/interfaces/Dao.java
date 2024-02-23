package access.interfaces;

import java.util.List;

public interface Dao<T> {

    void insertar(T obj);

    void modificar(T obj);

    void eliminar(T obj);

    T obtener(int id);

    List<T> obtenerTodos();
}