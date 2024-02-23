package presentation;


import access.impl.ClienteDao;
import access.impl.HabitacionDao;
import access.impl.ProductoDao;
import access.impl.ReservaDao;
import domain.entity.Cliente;
import domain.entity.Habitacion;
import domain.entity.Producto;
import domain.entity.Reserva;
import domain.model.InformeReservas;
import enums.Turno;

import java.util.List;

public class Pruebas {
    public static void main(String[] args) {
        ReservaDao reservaDao = new ReservaDao();
        List<Reserva> reservas = reservaDao.obtenerTodos();
        for (Reserva reserva : reservas) {
            System.out.println(reserva.toString());
        }
        HabitacionDao habitacionDao = new HabitacionDao();
        List<Habitacion> habitaciones = habitacionDao.obtenerTodos();
        for (Habitacion habitacion : habitaciones) {
            System.out.println(habitacion.toString());
        }
        ProductoDao productoDao = new ProductoDao();
        List<Producto> productos = productoDao.obtenerTodos();
        for (Producto producto : productos) {
            System.out.println(producto.toString());
        }
        ClienteDao clienteDao = new ClienteDao();
        List<Cliente> clientes = clienteDao.obtenerTodos();
        for (Cliente cliente : clientes) {
            System.out.println(cliente.toString());
        }
        InformeReservas informeReservas = new InformeReservas(reservas);
        List<Reserva> reservasFiltradas= informeReservas.filtrarPorTurno(Turno.MANIANA);
        for (Reserva reserva : reservasFiltradas) {
            System.out.println(reserva.toString());
        }
        System.out.println("Total:"+informeReservas.calcularTotal()+" Turno");
    }


}
