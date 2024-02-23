package presentation;

import aplication.servicios.HabitacionService;
import domain.entity.Habitacion;
import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class PresentadorHabitacion {

    private final HabitacionService habitacionService;
    @Getter
    @Setter
    private Habitacion habitacion;

    public PresentadorHabitacion(){
        this.habitacionService = new HabitacionService();
        this.habitacion = new Habitacion();
    }

    public void nuevaHabitacion(){
        this.habitacion = new Habitacion();
    }

    public void buscarCliente(){
        habitacion = habitacionService.obtener(habitacion.getId());
    }

    public void registrarCliente(){
        habitacionService.insertar(habitacion);
    }

    public void eliminarCliente(){
        habitacion = habitacionService.obtener(habitacion.getId());
        habitacionService.eliminar(habitacion);
    }

    public void editarCliente(){
        habitacionService.modificar(habitacion);
    }

}
