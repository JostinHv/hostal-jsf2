package presentation;

import aplication.servicios.ProductoService;
import domain.entity.Producto;
import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class PresentadorProducto implements Serializable {

    private final ProductoService productoService;
    @Getter
    @Setter
    private Producto producto;
    @Getter
    @Setter
    private List<Producto> listaProductos;

    public PresentadorProducto(){
        this.productoService = new ProductoService();
        this.producto = new Producto();
        this.listaProductos = new ArrayList<>();
    }

    public void nuevoProducto(){
        producto = new Producto();
    }

    public void listarProductos(){
        listaProductos = productoService.obtenerTodos();
    }

    public void buscarProducto(){
        producto = productoService.obtener(producto.getId());
    }

    public void registrarProducto(){
        productoService.insertar(producto);
    }

    public void eliminarProducto(){
        producto = productoService.obtener(producto.getId());
        productoService.eliminar(producto);
    }

    public void editarProducto(){
        productoService.modificar(producto);
    }

}
