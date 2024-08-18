package com.nvegas.ingwebapi.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@Entity
@Table(name = "venta", schema = "chikitinesbd")
public class VentaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idVenta", nullable = false)
    private int idVenta;
    @Basic
    @Column(name = "nroVenta", nullable = false, length = 50)
    private String nroVenta;
    @Basic
    @Column(name = "fecha", nullable = false, length = 50)
    private String fecha;
    @Basic
    @Column(name = "estado", nullable = false)
    private Boolean estado;
    @OneToOne
    @JoinColumn(name = "idCdp", referencedColumnName = "idCdp")
    private CdpEntity cdpByIdCdp;
    @OneToMany(mappedBy = "ventaByIdVenta")
    private Collection<DetalleVentaEntity> detalleVentasByIdVenta;

    @ManyToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente", nullable = false)
    private ClienteEntity clienteByIdCliente;

    @ManyToOne
    @JoinColumn(name = "idVendedor", referencedColumnName = "idVendedor", nullable = false)
    private VendedorEntity vendedorByIdVendedor;


}
