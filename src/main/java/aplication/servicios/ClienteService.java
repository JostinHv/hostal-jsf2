package aplication.servicios;

import access.impl.ClienteDao;
import domain.entity.Cliente;

import java.util.List;

public class ClienteService {
    private final ClienteDao clienteDao;

    public ClienteService(){
        this.clienteDao = new ClienteDao();
    }

    public void insertar(Cliente obj) {
        clienteDao.insertar(obj);
    }

    public void modificar(Cliente obj) {
        clienteDao.modificar(obj);
    }

    public boolean eliminar(Cliente obj) {
        return clienteDao.eliminar(obj);
    }

    public Cliente obtener(int id) {
        return clienteDao.obtener(id);
    }

    public Cliente obtenerPorNombre(String nombre){
        return clienteDao.obtenerPorNombre(nombre);
    }

    public List<Cliente> obtenerTodos() {
        return clienteDao.obtenerTodos();
    }


}
