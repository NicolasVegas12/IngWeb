package com.nvegas.ingwebapi.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "detalle_venta", schema = "chikitinesbd")
public class DetalleVentaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idDetalleVenta", nullable = false)
    private int idDetalleVenta;
    @Basic
    @Column(name = "monto", nullable = false, precision = 2)
    private double monto;

    @Basic
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @ManyToOne
    @JoinColumn(name = "idVenta", referencedColumnName = "idVenta", nullable = false)
    private VentaEntity ventaByIdVenta;
    @ManyToOne
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto", nullable = false)
    private ProductoEntity productoByIdProducto;


}
