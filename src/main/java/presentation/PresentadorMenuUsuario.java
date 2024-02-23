package presentation;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import aplication.ServicioCRUD;
import aplication.ServicioUsuario;
import domain.entity.Usuario;

@ManagedBean
@ViewScoped
public class PresentadorMenuUsuario implements Serializable {

	private static final long serialVersionUID = 987654321L;
	private ServicioCRUD<Usuario> sUsuario;
	private List<Usuario> usuarios;
	private Usuario usuario;

	public PresentadorMenuUsuario() {
		this.sUsuario = new ServicioUsuario();
		this.usuarios = sUsuario.lista();
	}

	public void openNew() {
		this.usuario = new Usuario();

	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String regresarMenu() {
		return "MenuAdministrador?faces-redirect=true";
	}

	public void guardar() {
		sUsuario.crear(usuario);
		this.usuario = null;
		usuarios = sUsuario.lista();
		PrimeFaces.current().executeScript("PF('addProductDialog').hide()");
		PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
	}

	public void modificar() {
		sUsuario.modificar(usuario);
		this.usuario = null;
		usuarios = sUsuario.lista();
		PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
		PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
	}

	public void eliminar() {
		sUsuario.eliminar(usuario);
		usuarios = sUsuario.lista();
		this.usuario = null;
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario removido"));
		PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
	}

}
