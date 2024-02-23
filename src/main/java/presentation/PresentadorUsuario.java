package presentation;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import domain.entity.Cuenta;

@ManagedBean
@SessionScoped
public class PresentadorUsuario implements Serializable {

	private static final long serialVersionUID = 123456789L;
	@ManagedProperty("#{presentadorLogin.cuenta}")
	private Cuenta cuenta;

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public String menuLibro() {
		return "MenuLibrosUsuario?faces-redirect=true";
	}

	public String menuReserva() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		externalContext.getSessionMap().put("cuenta", cuenta);
		return "MenuReserva?faces-redirect=true";
	}

	public String logout() {
		this.cuenta = null;
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	    externalContext.invalidateSession();
		return "Login?faces-redirect=true";
	}
}
