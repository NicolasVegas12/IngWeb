package com.nvegas.ingwebapi.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "detalle_pedido", schema = "chikitinesbd")
public class DetallePedidoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idDetallePedido", nullable = false)
    private int idDetallePedido;
    @Basic
    @Column(name = "monto", nullable = false, precision = 2)
    private double monto;

    @Basic
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @ManyToOne
    @JoinColumn(name = "idPedido", referencedColumnName = "idPedido", nullable = false)
    private PedidoEntity pedidoByIdPedido;
    @ManyToOne
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto", nullable = false)
    private ProductoEntity productoByIdProducto;


}
