package aplication.servicios;

import access.impl.ClienteDao;
import domain.entity.Cliente;

import javax.faces.bean.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ClienteService {
    private ClienteDao clienteDao;

    public void insertar(Cliente obj) {
        clienteDao.insertar(obj);
    }

    public void modificar(Cliente obj) {
        clienteDao.modificar(obj);
    }

    public void eliminar(Cliente obj) {
        clienteDao.eliminar(obj);
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
