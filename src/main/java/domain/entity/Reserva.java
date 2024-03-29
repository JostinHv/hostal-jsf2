package domain.entity;

import enums.Estado;
import enums.Turno;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalTime horaIngreso;
	private LocalTime horaSalida;
	private int nroPersonas;
	@Enumerated(EnumType.STRING)
	private Estado estado;
	@Enumerated(EnumType.STRING)
	private Turno turno;
	private LocalDate fechaIngreso;
	private LocalDate fechaSalida;
	private Double costoYape;
	private Double costoEfectivo;
	@ManyToOne
	@JoinColumn(name = "habitacion")
	private Habitacion habitacion;
	@ManyToOne
	@JoinColumn(name = "cliente")
	private Cliente cliente;
}