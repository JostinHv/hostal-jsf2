package presentation;

import aplication.servicios.HabitacionService;
import domain.entity.Habitacion;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class PresentadorHabitacion implements Serializable {

    private final HabitacionService habitacionService;
    @Getter
    @Setter
    private Habitacion habitacion;
    @Getter
    @Setter
    private List<Habitacion> listaHabitaciones;
    @Getter
    @Setter
    private List<Habitacion> listaHabitacionesSeleccionadas;

    public PresentadorHabitacion() {
        this.habitacionService = new HabitacionService();
        this.habitacion = new Habitacion();
        this.listaHabitaciones = new ArrayList<>();
    }

    public void nuevaHabitacion() {
        habitacion = new Habitacion();
    }

    public List<Habitacion> listarHabitaciones() {
        return habitacionService.obtenerTodos();
    }

    public void buscarHabitacion() {
        habitacion = habitacionService.obtener(habitacion.getId());
    }

    public void registrarHabitacion() {
        if (this.habitacion.getId() == 0) {
            habitacionService.insertar(habitacion);
            this.habitacion = null;
            this.listaHabitaciones = habitacionService.obtenerTodos();
        } else {
            this.editarHabitacion();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Habitación actualizada"));
        }
        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public void eliminarHabitacion() {
        habitacion = habitacionService.obtener(habitacion.getId());
        if (habitacionService.eliminar(habitacion)) {
            this.habitacion = null;
            this.listaHabitaciones = habitacionService.obtenerTodos();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Habitación Eliminada"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error",
                    "No se pudo eliminar la habitación. Verfique que no esté asociada a otro registro."));
        }
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public void editarHabitacion() {
        habitacionService.modificar(habitacion);
        this.habitacion = null;
        this.listaHabitaciones = habitacionService.obtenerTodos();
    }

    public String getEliminarBotonMensaje() {
        if (tieneHabitacionesSeleccionadas()) {
            int size = this.listaHabitacionesSeleccionadas.size();
            return size > 1 ? size + " habitaciones seleccionadas" : "1 habitación seleccionada";
        }

        return "Eliminar";
    }

    public boolean tieneHabitacionesSeleccionadas() {
        return this.listaHabitacionesSeleccionadas != null && !this.listaHabitacionesSeleccionadas.isEmpty();
    }

    public void eliminarHabitacionesSeleccionadas() {
        boolean esValido = true;
        for(Habitacion habitacion: listaHabitacionesSeleccionadas) {
            esValido &= habitacionService.eliminar(habitacionService.obtener(habitacion.getId()));
        }
        if (esValido) {
            this.listaHabitaciones.removeAll(this.listaHabitacionesSeleccionadas);
            this.listaHabitacionesSeleccionadas = null;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Habitaciones Eliminadas"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error",
                    "No se pudo eliminar alguna habitación. Verfique que no esté asociada a otro registro."));
        }
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
        PrimeFaces.current().executeScript("PF('dtProducts').clearFilters()");
    }
}
