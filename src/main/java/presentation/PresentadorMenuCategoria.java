package presentation;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import aplication.ServicioCRUD;
import aplication.ServicioCategoria;
import domain.entity.Categoria;

@ManagedBean
@ViewScoped
public class PresentadorMenuCategoria implements Serializable {

	private static final long serialVersionUID = 987654321L;
	private ServicioCRUD<Categoria> sCategoria;
	private Categoria categoria;
	private List<Categoria> categorias;

	public PresentadorMenuCategoria() {
		this.sCategoria = new ServicioCategoria();
		this.categorias = sCategoria.lista();
	}

	public void openNew() {
		this.categoria = new Categoria();
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void guardar() {
		sCategoria.crear(categoria);
		this.categoria = null;
		categorias = sCategoria.lista();
		PrimeFaces.current().executeScript("PF('addProductDialog').hide()");
		PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
	}

	public void modificar() {
		sCategoria.modificar(categoria);
		this.categoria = null;
		categorias = sCategoria.lista();
		PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
		PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
	}

	public void eliminar() {
		sCategoria.eliminar(categoria);
		this.categoria = null;
		categorias = sCategoria.lista();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Categoria removida"));
		PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
	}

	public String regresarMenu() {
		return "MenuAdministrador?faces-redirect=true";
	}

}
