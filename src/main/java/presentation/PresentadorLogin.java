package presentation;

import aplication.servicios.LoginService;
import domain.entity.Empleado;
import lombok.Getter;
import lombok.Setter;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class PresentadorLogin  implements Serializable {

	private LoginService loginService;
	@Getter
	@Setter
	private Empleado empleadoAutenticado;

	public PresentadorLogin() {
		this.loginService = new LoginService();
		this.empleadoAutenticado= new Empleado();
	}

	public String login() {
		empleadoAutenticado = loginService.autenticar(empleadoAutenticado.getUsername(), empleadoAutenticado.getPassword());
		if (empleadoAutenticado != null) {
			return "Home?faces-redirect=true";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Invalid credentials"));
			return null;
		}
	}

}
