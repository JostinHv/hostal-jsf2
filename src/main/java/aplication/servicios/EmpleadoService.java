package aplication.servicios;

import access.impl.EmpleadoDao;
import domain.entity.Empleado;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class EmpleadoService {
    @Inject
    private EmpleadoDao empleadoDao;

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
