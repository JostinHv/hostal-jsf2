package domain.strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import domain.entity.Reserva;
import domain.entity.Usuario;

public class CompositeReglasReserva implements ReglasReserva {
	private List<ReglasReserva> reglasReserva;

	public CompositeReglasReserva(ReglasReserva... reglas) {
		this.reglasReserva = new ArrayList<>(Arrays.asList(reglas));
	}

	public void agregarReglas(ReglasReserva... reglas) {
		reglasReserva.addAll(Arrays.asList(reglas));
	}

	@Override
	public boolean puedeRealizarReserva(Usuario usuario, List<Reserva> reservas, Libro libro) {
		for (ReglasReserva regla : reglasReserva) {
			if (!regla.puedeRealizarReserva(usuario, reservas, libro)) {
				return false;
			}
		}
		return true;
	}

}
