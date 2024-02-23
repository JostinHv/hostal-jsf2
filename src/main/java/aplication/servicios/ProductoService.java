package aplication.servicios;


import access.impl.ProductoDao;
import domain.entity.Producto;

import java.util.List;

public class ProductoService {

    private final ProductoDao productoDao;

    public ProductoService(){
        this.productoDao = new ProductoDao();
    }

    public void insertar(Producto obj) {
        productoDao.insertar(obj);
    }

    public void modificar(Producto obj) {
        productoDao.modificar(obj);
    }

    public void eliminar(Producto obj) {
        productoDao.eliminar(obj);
    }

    public Producto obtener(int id) {
        return productoDao.obtener(id);
    }

    public List<Producto> obtenerTodos() {
        return productoDao.obtenerTodos();
    }
}
