package domain.strategy;

import java.util.List;

import domain.entity.Libro;
import domain.entity.Reserva;
import domain.entity.Usuario;

public class LimiteReservasEstudiante implements ReglasReserva {
	private static final int LIMITE_RESERVAS = 3;

	public boolean puedeRealizarReserva(Usuario usuario, List<Reserva> reservas, Libro libro) {
		int reservasEstudiante = 0;
		for (Reserva reservaEncontradas : reservas) {
			if (reservaEncontradas.getUsuario().getID() == usuario.getID()
					&& reservaEncontradas.getEstado().equals("Activo")) {
				reservasEstudiante++;
			}
		}
		return reservasEstudiante < LIMITE_RESERVAS;
	}
}
