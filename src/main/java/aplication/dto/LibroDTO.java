package aplication.dto;

import java.util.List;

public class LibroDTO {
	private int ID;
	private int categoriaID;
	private List<Integer> autoresIDs;
	private String titulo;
	private String estado;
	private int nroIngreso;
	private String editorial;
	private Long ISSN;
	private String descripcion;
	private String autoresString;

	public LibroDTO() {

	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getCategoriaID() {
		return categoriaID;
	}

	public void setCategoriaID(int categoriaID) {
		this.categoriaID = categoriaID;
	}

	public List<Integer> getAutoresIDs() {
		return autoresIDs;
	}

	public void setAutoresIDs(List<Integer> autoresIDs) {
		this.autoresIDs = autoresIDs;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getNroIngreso() {
		return nroIngreso;
	}

	public void setNroIngreso(int nroIngreso) {
		this.nroIngreso = nroIngreso;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public Long getISSN() {
		return ISSN;
	}

	public void setISSN(Long iSSN) {
		ISSN = iSSN;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getAutoresString() {
		return autoresString;
	}

	public void setAutoresString(String autoresString) {
		this.autoresString = autoresString;
	}

	@Override
	public String toString() {
		return "LibroDTO [ID=" + ID + ", categoriaID=" + categoriaID + ", autoresIDs=" + autoresIDs + ", titulo="
				+ titulo + ", estado=" + estado + ", nroIngreso=" + nroIngreso + ", editorial=" + editorial + ", ISSN="
				+ ISSN + ", descripcion=" + descripcion + ", autoresString=" + autoresString + "]";
	}
	

}
