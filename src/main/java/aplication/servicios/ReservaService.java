package aplication.servicios;

import access.impl.ReservaDao;
import domain.entity.Reserva;

import java.util.List;

public class ReservaService {
    private final ReservaDao reservaDao;

    public ReservaService(){
        this.reservaDao = new ReservaDao();
    }

    public void insertar(Reserva obj) {
        reservaDao.insertar(obj);
    }

    public void modificar(Reserva obj) {
        reservaDao.modificar(obj);
    }

    public void eliminar(Reserva obj) {
        reservaDao.eliminar(obj);
    }

    public Reserva obtener(int id) {
        return reservaDao.obtener(id);
    }

    public List<Reserva> obtenerTodos() {
        return reservaDao.obtenerTodos();
    }
}