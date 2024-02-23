package aplication.servicios;

import access.impl.ReservaDao;
import domain.entity.Reserva;

import javax.faces.bean.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ReservaService {
    private ReservaDao reservaDao;

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