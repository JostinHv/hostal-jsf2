package aplication.servicios;


import access.impl.HabitacionDao;
import domain.entity.Habitacion;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class HabitacionService {
    @Inject
    private HabitacionDao habitacionDao;

    public void insertar(Habitacion obj) {
        habitacionDao.insertar(obj);
    }

    public void modificar(Habitacion obj) {
        habitacionDao.modificar(obj);
    }

    public void eliminar(Habitacion obj) {
        habitacionDao.eliminar(obj);
    }

    public Habitacion obtener(int id) {
        return habitacionDao.obtener(id);
    }

    public List<Habitacion> obtenerTodos() {
        return habitacionDao.obtenerTodos();
    }
}