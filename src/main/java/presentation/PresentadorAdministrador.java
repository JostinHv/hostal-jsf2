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
public class PresentadorAdministrador implements Serializable {

	private static final long serialVersionUID = 987654321L;
	@ManagedProperty("#{presentadorLogin.cuenta}")
	private Cuenta cuenta;
	public PresentadorAdministrador() {
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public String logout() {
		this.cuenta=null;
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	    externalContext.invalidateSession();
		return "Login?faces-redirect=true";
	}

	public String menuLibro() {
		return "MenuLibros?faces-redirect=true";
	}

	public String menuCategoria() {
		return "MenuCategoria?faces-redirect=true";
	}

	public String menuAutor() {
		return "MenuAutor?faces-redirect=true";
	}

	public String menuUsuario() {
		return "MenuUsuarioCrud?faces-redirect=true";
	}
}
