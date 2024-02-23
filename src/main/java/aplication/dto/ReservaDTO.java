package aplication.dto;

import java.time.LocalDate;

public class ReservaDTO {
	private int ID;
	private int ID_Usuario;
	private int ID_Libro;
	private LocalDate fechaReserva;
	private LocalDate fechaLimite;
	private String estado;

	public ReservaDTO() {

	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getID_Usuario() {
		return ID_Usuario;
	}

	public void setID_Usuario(int iD_Usuario) {
		ID_Usuario = iD_Usuario;
	}

	public int getID_Libro() {
		return ID_Libro;
	}

	public void setID_Libro(int iD_Libro) {
		ID_Libro = iD_Libro;
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

}
