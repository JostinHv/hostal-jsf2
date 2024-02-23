package aplication;

import java.util.ArrayList;
import java.util.List;

import aplication.dto.LibroDTO;
import aplication.dto.ReservaDTO;
import domain.entity.Libro;
import domain.entity.Reserva;
import domain.entity.Usuario;
import domain.model.ReservaModel;

public class ServicioReserva extends ServicioCRUD<Reserva> {

	private ReservaModel modelo;
	private ServicioLibro sLibro;
	private ServicioCRUD<Usuario> sUsuario;

	public ServicioReserva() {
		this.modelo = new ReservaModel();
		this.sLibro = new ServicioLibro();
		this.sUsuario = new ServicioUsuario();
	}

	private Reserva transformarObjeto(ReservaDTO dto) {
		Reserva reserva = new Reserva();
		LibroDTO libroDTO = sLibro.consultar(dto.getID_Libro());
		Libro libroEncontrado = sLibro.libroDTOALibro(libroDTO);
		Usuario usuarioEncontrado = sUsuario.consultar(dto.getID_Usuario());
		System.out.println(dto.toString());
		if (libroEncontrado == null || usuarioEncontrado == null) {
			throw new IllegalArgumentException("Sin libro o usuario");
		}
		reserva.setID(dto.getID());
		reserva.setFechaLimite(dto.getFechaLimite());
		reserva.setFechaReserva(dto.getFechaReserva());
		reserva.setLibro(libroEncontrado);
		reserva.setUsuario(usuarioEncontrado);
		return reserva;
	}

	public ReservaDTO convertirAReservaDTO(Reserva reserva) {
		ReservaDTO reservaDTO = new ReservaDTO();
		reservaDTO.setID(reserva.getID());
		reservaDTO.setID_Usuario(reserva.getUsuario().getID());
		reservaDTO.setID_Libro(reserva.getLibro().getID());
		reservaDTO.setFechaReserva(reserva.getFechaReserva());
		reservaDTO.setFechaLimite(reserva.getFechaLimite());
		reservaDTO.setEstado(reserva.getEstado());
		return reservaDTO;
	}

	public void realizarReserva(ReservaDTO obj) {
		Reserva reserva = transformarObjeto(obj);
		crear(reserva);
	}

	public List<ReservaDTO> obtenerReservasUsuario(int id) {
		List<Reserva> reservas = modelo.usuarioReservas(id);
		List<ReservaDTO> reservasDtos = new ArrayList<ReservaDTO>();
		for (Reserva reserva : reservas) {
			reservasDtos.add(convertirAReservaDTO(reserva));
		}
		return reservasDtos;
	}

	public void cancelarReserva(ReservaDTO obj) {
		Reserva libro = transformarObjeto(obj);
		modelo.cancelarReserva(libro);
	}

	@Override
	public Reserva consultar(int ID) {
		return modelo.consultar(ID);
	}

	@Override
	public Reserva crear(Reserva obj) {
		return modelo.realizarReserva(obj);
	}

	@Override
	public Reserva modificar(Reserva obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Reserva obj) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Reserva> lista() {
		return modelo.lista();
	}

}
