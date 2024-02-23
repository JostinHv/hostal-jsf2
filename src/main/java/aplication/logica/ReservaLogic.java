package aplication.logica;

import aplication.servicios.ClienteService;
import aplication.servicios.HabitacionService;
import aplication.servicios.ReservaService;
import domain.entity.Cliente;
import domain.entity.Habitacion;
import domain.entity.Reserva;
import lombok.Data;

import java.util.List;

@Data
public class ReservaLogic {

    private ReservaService reservaService;
    private ClienteService clienteService;
    private HabitacionService habitacionService;
    private Reserva reserva;
    private Cliente cliente;
    private Habitacion habitacion;

    public List<Reserva> listarReservas(){
        return reservaService.obtenerTodos();
    }

    public void crearReserva(){
        Cliente clienteBD = clienteService.obtenerPorNombre(cliente.getNombre());
        if(clienteBD != null){
            cliente = clienteBD;
        }else{
            clienteService.insertar(cliente);
        }
        reserva.setCliente(clienteService.obtenerPorNombre(cliente.getNombre()));

        reservaService.insertar(reserva);
    }

    public void consultarReserva(int id){
        reserva = reservaService.obtener(id);
    }




}
