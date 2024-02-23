package presentation;

import aplication.servicios.HabitacionService;
import aplication.servicios.ClienteService;
import aplication.servicios.ReservaService;
import domain.entity.Habitacion;
import domain.entity.Cliente;
import domain.entity.Reserva;
import enums.Estado;
import enums.Turno;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ManagedBean
@SessionScoped
public class PresentadorReserva implements Serializable {

    private final ReservaService reservaService;
    private final HabitacionService habitacionService;
    private final ClienteService clienteService;

    @Getter
    @Setter
    private Reserva reserva;

    @Getter
    @Setter
    private List<Reserva> listaReservas;

    @Getter
    @Setter
    private List<Reserva> listaReservasSeleccionadas;

    @Getter
    @Setter
    private List<Habitacion> habitaciones;

    @Getter
    @Setter
    private List<Cliente> clientes;

    @Getter
    @Setter
    private List<Estado> estados;

    @Getter
    @Setter
    private List<Turno> turnos;


    public PresentadorReserva() {
        this.reservaService = new ReservaService();
        this.habitacionService = new HabitacionService();
        this.clienteService = new ClienteService();

        this.reserva = new Reserva();
        this.listaReservas = new ArrayList<>();
        this.listaReservasSeleccionadas = new ArrayList<>();
        this.habitaciones = habitacionService.obtenerTodos();
        this.clientes = clienteService.obtenerTodos();
        this.estados = Arrays.asList(Estado.values());
        this.turnos = Arrays.asList(Turno.values());
    }

    public void nuevaReserva() {
        this.reserva = new Reserva();
        this.reserva.setCliente(new Cliente());
        this.reserva.setHabitacion(new Habitacion());
    }


    public List<Reserva> listarReservas() {
        return reservaService.obtenerTodos();
    }

    public void buscarReserva() {
        reserva = reservaService.obtener(reserva.getId());
    }

    public void registrarReserva() {
        if (this.reserva.getId() == 0) {
            Habitacion habitacion = habitacionService.obtener(reserva.getHabitacion().getId());
            Cliente cliente = clienteService.obtener(reserva.getCliente().getId());
            this.reserva.setHabitacion(habitacion);
            this.reserva.setCliente(cliente);
            reservaService.insertar(reserva);
            this.reserva = null;
            this.listaReservas = reservaService.obtenerTodos();
        } else {
            this.editarReserva();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Reserva actualizada"));
        }
        PrimeFaces.current().executeScript("PF('manageReservaDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-reservas");
    }

    public void eliminarReserva() {
        reserva = reservaService.obtener(reserva.getId());
        reservaService.eliminar(reserva);
        this.reserva = null;
        this.listaReservas = reservaService.obtenerTodos();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Reserva Eliminada"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-reservas");
    }

    public void editarReserva() {
        reservaService.modificar(reserva);
        this.reserva = null;
        this.listaReservas = reservaService.obtenerTodos();
    }

    public String getEliminarBotonMensaje() {
        if (tieneReservasSeleccionadas()) {
            int size = this.listaReservasSeleccionadas.size();
            return size > 1 ? size + " reservas seleccionadas" : "1 reserva seleccionada";
        }

        return "Eliminar";
    }

    public boolean tieneReservasSeleccionadas() {
        return this.listaReservasSeleccionadas != null && !this.listaReservasSeleccionadas.isEmpty();
    }

    public void eliminarReservasSeleccionadas() {
        this.listaReservas.removeAll(this.listaReservasSeleccionadas);
        this.listaReservasSeleccionadas = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Reservas Eliminadas"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-reservas");
        PrimeFaces.current().executeScript("PF('dtReservas').clearFilters()");
    }


}
