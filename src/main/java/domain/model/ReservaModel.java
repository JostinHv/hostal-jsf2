package domain.model;

import access.impl.ClienteDao;
import access.impl.HabitacionDao;
import domain.entity.Cliente;
import domain.entity.Habitacion;
import domain.entity.Reserva;

public class ReservaModel {
    private ClienteDao clienteDao;
    private HabitacionDao habitacionDao;

    public void crearReserva(Reserva reserva) {
        Cliente cliente = clienteDao.obtener(reserva.getCliente().getId());
        Habitacion habitacion=habitacionDao.obtener(reserva.getHabitacion().getId());
        reserva.setCliente(cliente);
        reserva.setHabitacion(habitacion);
    }


}
