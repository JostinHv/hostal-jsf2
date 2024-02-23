package aplication.servicios;

import access.impl.EmpleadoDao;
import domain.entity.Empleado;
public class LoginService {
    private final EmpleadoDao empleadoDao;

    public LoginService() {
        this.empleadoDao = new EmpleadoDao();
    }

    public Empleado autenticar(String username, String password) {
        Empleado empleado = empleadoDao.obtenerPorUsername(username);
        if (empleado != null && empleado.getPassword().equals(password)) {
            return empleado;
        } else {
            return null;
        }
    }
}
