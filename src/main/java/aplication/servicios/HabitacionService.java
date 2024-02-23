package aplication.servicios;


import access.impl.HabitacionDao;
import domain.entity.Habitacion;

import java.util.List;

public class HabitacionService {
    private final HabitacionDao habitacionDao;

    public HabitacionService(){
        this.habitacionDao = new HabitacionDao();
    }

    public void insertar(Habitacion obj) {
        habitacionDao.insertar(obj);
    }

    public void modificar(Habitacion obj) {
        habitacionDao.modificar(obj);
    }

    public boolean eliminar(Habitacion obj) {
        return habitacionDao.eliminar(obj);
    }

    public Habitacion obtener(int id) {
        return habitacionDao.obtener(id);
    }

    public List<Habitacion> obtenerTodos() {
        return habitacionDao.obtenerTodos();
    }
}