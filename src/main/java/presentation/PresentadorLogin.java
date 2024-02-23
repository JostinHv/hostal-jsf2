package presentation;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import domain.entity.Usuario;

@ManagedBean
@SessionScoped
public class PresentadorLogin implements Serializable {

	private static final long serialVersionUID = -7590257808781595903L;

	private String cuenta;

	public PresentadorLogin() {

	}

	public String getCuenta() {
		return "hola";
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public String autenticarse() {

		return null;
	}

}
