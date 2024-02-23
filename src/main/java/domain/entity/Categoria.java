package domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {

	@Id
	@Column(name = "idCategoria")
	private int ID;

	@Column(name = "carrera")
	private String Categoria;

	@Column(name = "descripcion")
	private String Descripcion;

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getCategoria() {
		return Categoria;
	}

	public void setCategoria(String Categoria) {
		this.Categoria = Categoria;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.Descripcion = descripcion;
	}

}
