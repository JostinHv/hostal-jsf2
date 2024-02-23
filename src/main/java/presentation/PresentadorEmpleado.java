package presentation;

import aplication.servicios.EmpleadoService;
import domain.entity.Empleado;
import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class PresentadorEmpleado implements Serializable {

    private final EmpleadoService empleadoService;

    @Getter
    @Setter
    private Empleado empleado;
    @Getter
    @Setter
    private List<Empleado> listaEmpleados;

    public PresentadorEmpleado(){
        this.empleadoService = new EmpleadoService();
        this.empleado = new Empleado();
        this.listaEmpleados = new ArrayList<>();
    }

    public void nuevoEmpleado(){
        empleado = new Empleado();
    }

    public void listarEmpleados(){
        listaEmpleados = this.empleadoService.obtenerTodos();
    }

    public void buscarEmpleado(){
        empleado = this.empleadoService.consultar(empleado.getId());
    }

    public void registrarEmpleado(){
        empleado.setActivo(true);
        this.empleadoService.insertar(empleado);
    }

    public void eliminarEmpleado(){
        empleado = this.empleadoService.consultar(empleado.getId());
        empleado.setActivo(false);
        this.empleadoService.modificar(empleado);
    }

    public void editarEmpleado(){
        this.empleadoService.modificar(empleado);
    }

}
