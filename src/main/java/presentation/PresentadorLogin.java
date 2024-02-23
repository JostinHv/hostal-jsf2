package presentation;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import aplication.ServicioAutenticacion;
import domain.entity.Administrador;
import domain.entity.Cuenta;
import domain.entity.Usuario;

@ManagedBean
@SessionScoped
public class PresentadorLogin implements Serializable {

	private static final long serialVersionUID = -7590257808781595903L;
	private ServicioAutenticacion sAutenticacion;
	private Cuenta cuenta;

	public PresentadorLogin() {
		this.sAutenticacion = new ServicioAutenticacion();
		this.cuenta = new Usuario();
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public String autenticarse() {
		Cuenta tipoCuenta = sAutenticacion.autenticarse(cuenta);
		setCuenta(tipoCuenta);
		if (tipoCuenta instanceof Administrador) {
			return "MenuAdministrador?faces-redirect=true";
		}
		if (tipoCuenta instanceof Usuario) {
			return "MenuUsuario?faces-redirect=true";

		}
		return null;
	}

}
