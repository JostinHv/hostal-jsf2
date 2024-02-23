package presentation;

import aplication.servicios.EmpleadoService;
import domain.entity.Empleado;
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
public class PresentadorEmpleado implements Serializable {

    private final EmpleadoService empleadoService;

    @Getter
    @Setter
    private Empleado empleado;
    @Getter
    @Setter
    private List<Empleado> listaEmpleados;
    @Getter
    @Setter
    private List<Empleado> listaEmpleadosSeleccionados;

    public PresentadorEmpleado(){
        this.empleadoService = new EmpleadoService();
        this.empleado = new Empleado();
        this.listaEmpleados = new ArrayList<>();
    }

    public void nuevoEmpleado(){
        empleado = new Empleado();
    }

    public List<Empleado> listarEmpleados(){
        return this.empleadoService.obtenerTodos();
    }

    public void buscarEmpleado(){
        empleado = this.empleadoService.consultar(empleado.getId());
    }

    public void registrarEmpleado(){
        if (this.empleado.getId() == 0) {
            empleado.setActivo(true);
            empleadoService.insertar(empleado);
            this.empleado = null;
            this.listaEmpleados = empleadoService.obtenerTodos();
        } else {
            this.editarEmpleado();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empleado actualizado"));
        }
        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");

    }

    public void eliminarEmpleado(){
        empleado = empleadoService.consultar(empleado.getId());
        if (empleadoService.eliminar(empleado)) {
            this.empleado = null;
            this.listaEmpleados = empleadoService.obtenerTodos();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empleado Eliminado"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error",
                    "No se pudo eliminar el empleado. Verfique que no esté asociado a otro registro."));
        }

        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public void editarEmpleado(){
        this.empleadoService.modificar(empleado);
        this.empleado = null;
        this.listaEmpleados = empleadoService.obtenerTodos();
    }

    public String getEliminarBotonMensaje() {
        if (tieneEmpleadosSeleccionados()) {
            int size = this.listaEmpleadosSeleccionados.size();
            return size > 1 ? size + " empleados seleccionados" : "1 empleado seleccionado";
        }

        return "Eliminar";
    }

    public boolean tieneEmpleadosSeleccionados() {
        return this.listaEmpleadosSeleccionados != null && !this.listaEmpleadosSeleccionados.isEmpty();
    }

    public void eliminarEmpleadosSeleccionados() {
        boolean esValido = true;
        for(Empleado empleado: listaEmpleadosSeleccionados) {
            esValido &= empleadoService.eliminar(empleadoService.consultar(empleado.getId()));
        }
        if (esValido) {
            this.listaEmpleados.removeAll(this.listaEmpleadosSeleccionados);
            this.listaEmpleadosSeleccionados = null;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empleados Eliminados"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error",
                    "No se pudo eliminar algun empleado. Verfique que no esté asociado a otro registro."));
        }
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
        PrimeFaces.current().executeScript("PF('dtProducts').clearFilters()");
    }

}
