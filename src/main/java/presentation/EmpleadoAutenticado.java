package presentation;

import domain.entity.Empleado;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class EmpleadoAutenticado implements Serializable {

    @ManagedProperty("#{presentadorLogin.empleadoAutenticado}")
    private Empleado empleadoAutenticado;

    public Empleado getEmpleadoAutenticado() {
        return empleadoAutenticado;
    }

    public void setEmpleadoAutenticado(Empleado empleadoAutenticado) {
        this.empleadoAutenticado = empleadoAutenticado;
    }

}