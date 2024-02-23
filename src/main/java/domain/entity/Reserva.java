package domain.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reserva")
public class Reserva {
	@Id
	@Column(name = "idReserva")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	@OneToOne
	@JoinColumn(name = "carnet", referencedColumnName = "id")
	private Usuario Usuario;
	
	@OneToOne
	@JoinColumn(name = "idLibro", referencedColumnName = "idLibro")
	private Libro Libro;
	
	@Column(name = "fechaReserva")
	private LocalDate fechaReserva;
	
	@Column(name = "fechaLimite")
	private LocalDate fechaLimite;
	
	@Column(name = "estado")
	private String estado;

	public Reserva() {

	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario usuario) {
		Usuario = usuario;
	}

	public Libro getLibro() {
		return Libro;
	}

	public void setLibro(Libro libro) {
		Libro = libro;
	}

	public LocalDate getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(LocalDate fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public LocalDate getFechaLimite() {
		return fechaLimite;
	}

	public void setFechaLimite(LocalDate fechaLimite) {
		this.fechaLimite = fechaLimite;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Reserva [ID=" + ID + ", Usuario=" + Usuario + ", Libro=" + Libro + ", fechaReserva=" + fechaReserva
				+ ", fechaLimite=" + fechaLimite + ", estado=" + estado + "]";
	}

}
