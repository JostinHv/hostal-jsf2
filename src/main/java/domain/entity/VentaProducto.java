package domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VentaProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany(mappedBy = "venta")
    private List<VentaProductoDetalle> lineasVenta;
    private LocalDate fecha;
}