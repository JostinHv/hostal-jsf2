package aplication.logica;

import com.jsf.hostaljsf.aplicacion.servicios.ClienteService;
import com.jsf.hostaljsf.aplicacion.servicios.HabitacionService;
import com.jsf.hostaljsf.aplicacion.servicios.ReservaService;
import com.jsf.hostaljsf.dominio.entidad.Cliente;
import com.jsf.hostaljsf.dominio.entidad.Habitacion;
import com.jsf.hostaljsf.dominio.entidad.Reserva;
import lombok.Data;

import javax.inject.Inject;
import java.util.List;

@Data
public class ReservaLogic {

    @Inject
    private ReservaService reservaService;
    @Inject
    private ClienteService clienteService;
    @Inject
    private HabitacionService habitacionService;
    @Inject
    private Reserva reserva;
    @Inject
    private Cliente cliente;
    @Inject
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
