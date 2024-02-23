package presentation;

import aplication.servicios.ClienteService;
import domain.entity.Cliente;
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
public class PresentadorCliente implements Serializable {

    private final ClienteService clienteService;
    @Getter
    @Setter
    private Cliente cliente;
    @Getter
    @Setter
    private List<Cliente> listaClientes;
    @Getter
    @Setter
    private List<Cliente> listaClientesSeleccionados;


    public PresentadorCliente(){
        this.clienteService = new ClienteService();
        this.cliente = new Cliente();
        this.listaClientes = new ArrayList<>();
    }

    public void nuevoCliente(){
        cliente = new Cliente();
    }

    public void listarClientes(){
        listaClientes = clienteService.obtenerTodos();
    }

    public void buscarCliente(){
        cliente = clienteService.obtener(cliente.getId());
    }

    public void registrarCliente(){
        if (this.cliente.getId() == 0) {
        clienteService.insertar(cliente);
        this.cliente = null;
        this.listaClientes = clienteService.obtenerTodos();
        } else {
            this.editarCliente();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente actualizado"));
        }
        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public void eliminarCliente(){
        cliente = clienteService.obtener(cliente.getId());
        clienteService.eliminar(cliente);
        this.cliente = null;
        this.listaClientes = clienteService.obtenerTodos();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente Eliminado"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public void editarCliente(){
        clienteService.modificar(cliente);
        this.cliente = null;
        this.listaClientes = clienteService.obtenerTodos();
    }

    public String getEliminarBotonMensaje() {
        if (tieneClientesSeleccionados()) {
            int size = this.listaClientesSeleccionados.size();
            return size > 1 ? size + " clientes seleccionados" : "1 cliente seleccionado";
        }

        return "Eliminar";
    }

    public boolean tieneClientesSeleccionados() {
        return this.listaClientesSeleccionados != null && !this.listaClientesSeleccionados.isEmpty();
    }

    public void eliminarClientesSeleccionados() {
        this.listaClientes.removeAll(this.listaClientesSeleccionados);
        this.listaClientesSeleccionados = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Clientes Eliminados"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
        PrimeFaces.current().executeScript("PF('dtProducts').clearFilters()");
    }


}
