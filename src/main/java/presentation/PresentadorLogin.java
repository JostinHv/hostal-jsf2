package presentation;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import domain.entity.Usuario;

@ManagedBean
@SessionScoped
public class PresentadorLogin implements Serializable {

	private static final long serialVersionUID = -7590257808781595903L;

	private String usuario;
	private String contrasena;

	public String iniciarSesion(){
		//aquí va validación de usuario
		return "inicio";
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

}
