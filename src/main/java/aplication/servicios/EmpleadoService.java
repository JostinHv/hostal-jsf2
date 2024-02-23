package aplication.servicios;

import access.impl.EmpleadoDao;
import domain.entity.Empleado;

import java.util.List;


public class EmpleadoService {
    private final EmpleadoDao empleadoDao;

    public EmpleadoService(){
        this.empleadoDao = new EmpleadoDao();
    }

    public void insertar(Empleado obj) {
        empleadoDao.insertar(obj);
    }

    public void modificar(Empleado obj) {
        empleadoDao.modificar(obj);
    }

    public void eliminar(Empleado obj) {
        empleadoDao.eliminar(obj);
    }

    public Empleado consultar(int id) {
        return empleadoDao.obtener(id);
    }

    public List<Empleado> obtenerTodos() {
        return empleadoDao.obtenerTodos();
    }

}
