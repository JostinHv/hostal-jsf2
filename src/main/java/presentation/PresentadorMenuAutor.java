package presentation;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import aplication.ServicioAutor;
import aplication.ServicioCRUD;

@ManagedBean
@ViewScoped
public class PresentadorMenuAutor implements Serializable {

	private static final long serialVersionUID = 987654321L;
	private ServicioCRUD<Autor> sAutor;
	private List<Autor> autores;
	private Autor autor;

	public PresentadorMenuAutor() {
		this.sAutor = new ServicioAutor();
		this.autores = sAutor.lista();
	}

	public void openNew() {
		this.autor = new Autor();
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public String regresarMenu() {
		return "MenuAdministrador?faces-redirect=true";
	}

	public void guardar() {
		sAutor.crear(autor);
		this.autor = null;
		autores = sAutor.lista();
		PrimeFaces.current().executeScript("PF('addProductDialog').hide()");
		PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
	}

	public void modificar() {
		sAutor.modificar(autor);
		this.autor = null;
		autores = sAutor.lista();
		PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
		PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
	}

	public void eliminar() {
		sAutor.eliminar(autor);
		autores = sAutor.lista();
		this.autor = null;
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Autor removido"));
		PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
	}
}
