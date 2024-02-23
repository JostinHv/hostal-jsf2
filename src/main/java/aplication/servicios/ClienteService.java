package aplication.servicios;

import com.jsf.hostaljsf.acceso.impl.ClienteDao;
import com.jsf.hostaljsf.dominio.entidad.Cliente;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ClienteService {
    @Inject
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
