package domain.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Libro")
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idLibro")
	private int ID;

	@Column(name = "titulo")
	private String Titulo;

	@Column(name = "estado")
	private String Estado;

	@Column(name = "nroIngreso")
	private int nroIngreso;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "libroautor", joinColumns = @JoinColumn(name = "idLibro"), inverseJoinColumns = @JoinColumn(name = "idAutor"))
	private List<Autor> Autores;

	@Column(name = "editorial")
	private String Editorial;

	@Column(name = "ISSN")
	private Long ISSN;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idCategoria")
	private Categoria Categoria;

	@Column(name = "descripcion")
	private String Descripcion;

	public Libro() {

	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public int getNroIngreso() {
		return nroIngreso;
	}

	public void setNroIngreso(int nroIngreso) {
		this.nroIngreso = nroIngreso;
	}

	public List<Autor> getAutores() {
		return Autores;
	}

	public void setAutores(List<Autor> autores) {
		Autores = autores;
	}

	public String getEditorial() {
		return Editorial;
	}

	public void setEditorial(String editorial) {
		this.Editorial = editorial;
	}

	public Long getISSN() {
		return ISSN;
	}

	public void setISSN(Long iSSN) {
		this.ISSN = iSSN;
	}

	public Categoria getCategoria() {
		return Categoria;
	}

	public void setCategoria(Categoria categoria) {
		Categoria = categoria;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Libro [ID=" + ID + ", Titulo=" + Titulo + ", Estado=" + Estado + ", nroIngreso=" + nroIngreso
				+ ", Autores=" + Autores + ", Editorial=" + Editorial + ", ISSN=" + ISSN + ", Categoria=" + Categoria
				+ ", Descripcion=" + Descripcion + "]";
	}

	
}
