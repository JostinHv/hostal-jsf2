package aplication.servicios;

import com.jsf.hostaljsf.acceso.impl.ReservaDao;
import com.jsf.hostaljsf.dominio.entidad.Reserva;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ReservaService {
    @Inject
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