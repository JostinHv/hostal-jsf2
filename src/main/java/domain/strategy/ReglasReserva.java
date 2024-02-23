package domain.strategy;

import java.util.List;

import domain.entity.Libro;
import domain.entity.Reserva;
import domain.entity.Usuario;

public interface ReglasReserva {
	public boolean puedeRealizarReserva(Usuario usuario, List<Reserva> reservas, Libro libro);

}
