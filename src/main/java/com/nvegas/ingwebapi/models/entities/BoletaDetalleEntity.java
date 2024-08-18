package com.nvegas.ingwebapi.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@Entity
@Table(name = "boleta_detalle", schema = "chikitinesbd")
public class BoletaDetalleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idBoletaDetalle", nullable = false)
    private int idBoletaDetalle;
    @Basic
    @Column(name = "monto", nullable = false, precision = 2)
    private double monto;

    @Basic
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @OneToMany(mappedBy = "boletaDetalleByIdBoletaDetalle")
    private Collection<BoletaEntity> boletasByIdBoletaDetalle;
    @ManyToOne
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto", nullable = false)
    private ProductoEntity productoByIdProducto;


}
