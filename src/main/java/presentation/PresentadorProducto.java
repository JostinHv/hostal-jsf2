package presentation;

import aplication.servicios.ProductoService;
import domain.entity.Producto;
import enums.Categoria;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.time.LocalDate;
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
    @Getter
    @Setter
    private List<Producto> listaProductosSelecionados;


    public PresentadorProducto(){
        this.productoService = new ProductoService();
        this.producto = new Producto();
        this.listaProductos = new ArrayList<>();
    }

    public void nuevoProducto(){
        producto = new Producto();
    }

    public List<Producto> listarProductos() {
        return productoService.obtenerTodos();
    }

    public void buscarProducto(){
        producto = productoService.obtener(producto.getId());
    }

    public void registrarProducto(){
        if (this.producto.getId() == 0) {
            productoService.insertar(producto);
            this.producto = null;
            this.listaProductos = productoService.obtenerTodos();
        } else {
            this.editarProducto();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto actualizado"));
        }
        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public void eliminarProducto(){
        producto = productoService.obtener(producto.getId());
        if (productoService.eliminar(producto)) {
            this.producto = null;
            this.listaProductos = productoService.obtenerTodos();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto Eliminado"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error",
                    "No se pudo eliminar el producto. Verfique que no esté asociado a otro registro."));
        }
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public void editarProducto(){
        productoService.modificar(producto);
        this.producto = null;
        this.listaProductos = productoService.obtenerTodos();
    }

    public String getEliminarBotonMensaje() {
        if (tieneProductosSeleccionados()) {
            int size = this.listaProductosSelecionados.size();
            return size > 1 ? size + " productos seleccionados" : "1 producto seleccionado";
        }
        return "Eliminar";
    }

    public boolean tieneProductosSeleccionados() {
        return this.listaProductosSelecionados != null && !this.listaProductosSelecionados.isEmpty();
    }

    public void eliminarProductosSeleccionados() {
        boolean esValido = true;
        for (Producto producto: listaProductosSelecionados) {
            esValido &= productoService.eliminar(productoService.obtener(producto.getId()));
        }
        if (esValido) {
            this.listaProductos.removeAll(this.listaProductosSelecionados);
            this.listaProductosSelecionados = null;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto Eliminados"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error",
                    "No se pudo eliminar algun producto. Verfique que no esté asociado a otro registro."));
        }
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
        PrimeFaces.current().executeScript("PF('dtProducts').clearFilters()");
    }

    public Categoria[] getValoreCategoria() {
        return Categoria.values();
    }
}
