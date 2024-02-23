package presentation;

import aplication.servicios.ClienteService;
import domain.entity.Cliente;
import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
        clienteService.insertar(cliente);
    }

    public void eliminarCliente(){
        cliente = clienteService.obtener(cliente.getId());
        clienteService.eliminar(cliente);
    }

    public void editarCliente(){
        clienteService.modificar(cliente);
    }

}
