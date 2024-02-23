package domain.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import access.dao.AbstractDAOFactory;
import access.dao.DAO;
import access.dao.FactoryType;
import domain.entity.Reserva;
import domain.strategy.CompositeReglasReserva;
import domain.strategy.LimiteReservasEstudiante;
import domain.strategy.ReservarLibroDisponible;
import domain.strategy.ReglasReserva;

public class ReservaModel extends AbsCRUD<Reserva> {
	private List<Reserva> reservas;
	private DAO<Reserva> reservaDAO;
	private ReglasReserva reglasReserva;
	private LibroModel blLibro;

	public ReservaModel() {
		this.reservaDAO = AbstractDAOFactory.getFactory(FactoryType.SQL_DAO_FACTORY).getReservaDAO();
		this.reservas = reservaDAO.lista();
		this.reglasReserva = new CompositeReglasReserva(new LimiteReservasEstudiante(), new ReservarLibroDisponible());
		this.blLibro = new LibroModel();
	}

	public Reserva realizarReserva(Reserva obj) {
		if (reglasReserva.puedeRealizarReserva(obj.getUsuario(), reservas, obj.getLibro())) {
			LocalDate fechaActual = LocalDate.now();
			obj.setEstado("Activo");
			obj.setFechaReserva(fechaActual);
			obj.setFechaLimite(reservaPlazo(fechaActual));
			obj.setID(obj.getID());
			blLibro.reservarLibro(obj.getLibro());
			return this.crear(obj);
		} else {
			return null;
		}
	}

	public Reserva cancelarReserva(Reserva obj) {
		obj.setEstado("Cancelado");
		blLibro.liberarLibro(obj.getLibro());
		this.modificar(obj);
		return obj;
	}

	public List<Reserva> usuarioReservas(int id) {
		List<Reserva> reservasUsuario = new ArrayList<Reserva>();
		for (Reserva reserva : lista()) {
			if (reserva.getUsuario().getID() == id) {
				reservasUsuario.add(reserva);
			}
		}
		return reservasUsuario;
	}

	private LocalDate reservaPlazo(LocalDate fechaActual) {
		LocalDate fechaLimite = fechaActual.plusDays(2);
		return fechaLimite;
	}

	@Override
	public Reserva crear(Reserva obj) {
		return reservaDAO.crear(obj);

	}

	@Override
	public Reserva consultar(int ID) {
		return reservaDAO.consultar(ID);
	}

	@Override
	public Reserva modificar(Reserva obj) {
		return reservaDAO.modificar(obj);
	}

	@Override
	public void eliminar(Reserva obj) {
		reservaDAO.eliminar(obj);
	}

	@Override
	public List<Reserva> lista() {
		this.reservas = reservaDAO.lista();
		return reservas;
	}
}
