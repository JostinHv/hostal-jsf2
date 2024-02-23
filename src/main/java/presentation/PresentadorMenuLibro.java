package presentation;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import aplication.ServicioCRUD;
import aplication.ServicioLibro;
import aplication.dto.LibroDTO;

@ManagedBean
@ViewScoped
public class PresentadorMenuLibro implements Serializable {

	private static final long serialVersionUID = 987625454321L;
	private ServicioCRUD<LibroDTO> sLibro;
	private LibroDTO libroDTO;
	private List<LibroDTO> libros;

	public PresentadorMenuLibro() {
		this.sLibro = new ServicioLibro();
		this.libros = sLibro.lista();
	}

	public void openNew() {
		this.libroDTO = new LibroDTO();
	}

	public LibroDTO getLibroDTO() {
		return libroDTO;
	}

	public void setLibroDTO(LibroDTO libroDTO) {
		this.libroDTO = libroDTO;
	}

	public List<LibroDTO> getLibros() {
		return libros;
	}

	public void setLibros(List<LibroDTO> libros) {
		this.libros = libros;
	}

	public void guardar() {
		sLibro.crear(libroDTO);
		this.libroDTO = null;
		libros = sLibro.lista();
		PrimeFaces.current().executeScript("PF('addProductDialog').hide()");
		PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
	}

	public void modificar() {
		sLibro.modificar(libroDTO);
		this.libroDTO = null;
		libros = sLibro.lista();
		PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
		PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
	}

	public void eliminar() {
		sLibro.eliminar(libroDTO);
		libros = sLibro.lista();
		this.libroDTO = null;
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Libro removido"));
		PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
	}

	public String regresarMenu() {
		return "MenuAdministrador?faces-redirect=true";
	}

	public String regresarMenuUsuario() {
		return "MenuUsuario?faces-redirect=true";
	}

}
