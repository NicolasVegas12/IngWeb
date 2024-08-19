package com.nvegas.ingwebapi.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.Collection;

@Getter
@Setter
@Entity
@Table(name = "pedido", schema = "chikitinesbd")
public class PedidoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idPedido", nullable = false)
    private int idPedido;
    @Basic
    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @OneToMany(mappedBy = "pedidoByIdPedido")
    private Collection<DetallePedidoEntity> detallePedidosByIdPedido;
    @ManyToOne
    @JoinColumn(name = "idProveedor", referencedColumnName = "idProveedor", nullable = false)
    private ProveedorEntity proveedorByIdProveedor;
    @ManyToOne
    @JoinColumn(name = "idVendedor", referencedColumnName = "idVendedor", nullable = false)
    private VendedorEntity vendedorByIdVendedor;
    @ManyToOne
    @JoinColumn(name = "idJefeCompras", referencedColumnName = "idJefeCompras", nullable = false)
    private JefeComprasEntity jefeComprasByIdJefeCompras;
    @ManyToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente", nullable = false)
    private ClienteEntity clienteByIdCliente;

}
