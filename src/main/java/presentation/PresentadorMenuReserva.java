package presentation;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import aplication.ServicioReserva;
import aplication.dto.ReservaDTO;

@ManagedBean
@SessionScoped
public class PresentadorMenuReserva implements Serializable {

	private static final long serialVersionUID = 987654321L;

	@ManagedProperty("#{presentadorUsuario.cuenta}")
	private Cuenta cuenta;

	private ServicioReserva sReserva;
	private ReservaDTO reservaDTO;
	private List<ReservaDTO> reservas;

	public PresentadorMenuReserva() {
		this.sReserva = new ServicioReserva();
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		this.cuenta = (Cuenta) externalContext.getSessionMap().get("cuenta");
		this.reservas = sReserva.obtenerReservasUsuario(cuenta.getID());
	}

	public void openNew() {
		this.reservaDTO = new ReservaDTO();
		this.reservaDTO.setID_Usuario(cuenta.getID());
	}

	public ReservaDTO getReservaDTO() {
		return reservaDTO;
	}

	public void setReservaDTO(ReservaDTO reservaDTO) {
		this.reservaDTO = reservaDTO;
	}

	public List<ReservaDTO> getReservas() {
		return reservas;
	}

	public void setReservas(List<ReservaDTO> reservas) {
		this.reservas = reservas;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public String regresarMenu() {
		return "MenuUsuario?faces-redirect=true";
	}

	public void reservar() {
		sReserva.realizarReserva(reservaDTO);
		this.reservaDTO = null;
		reservas = sReserva.obtenerReservasUsuario(cuenta.getID());
		PrimeFaces.current().executeScript("PF('addProductDialog').hide()");
		PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
	}

	public void cancelar() {
		sReserva.cancelarReserva(reservaDTO);
		reservas = sReserva.obtenerReservasUsuario(cuenta.getID());
		this.reservaDTO = null;
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Reserva cancelada"));
		PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
	}

}
