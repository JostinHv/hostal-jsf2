package domain.model;

import domain.entity.Reserva;
import enums.Turno;
import lombok.AllArgsConstructor;

import java.util.List;
@AllArgsConstructor
public class InformeReservas {

    private List<Reserva> reservas;

    public List<Reserva> filtrarPorTurno(Turno turno) {
        reservas.removeIf(reserva -> reserva.getTurno() != turno);
        return reservas;
    }

    public double calcularTotal(){
        double totalEfectivo= reservas.stream().mapToDouble(Reserva::getCostoEfectivo).sum();
        double totalYape= reservas.stream().mapToDouble(Reserva::getCostoYape).sum();
        return totalYape+totalEfectivo;
    }


}
