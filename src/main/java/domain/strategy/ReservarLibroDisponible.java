package domain.strategy;

import java.util.List;

import domain.entity.Reserva;
import domain.entity.Usuario;

public class ReservarLibroDisponible implements ReglasReserva {

	@Override
	public boolean puedeRealizarReserva(Usuario usuario, List<Reserva> reservas, Libro libro) {
		if (libro.getEstado().equals("Disponible")) {
			return true;
		}
		return false;
	}
}