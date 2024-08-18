package com.nvegas.ingwebapi.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "pago", schema = "chikitinesbd")
public class PagoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idPago", nullable = false)
    private int idPago;
    @Basic
    @Column(name = "fecha", nullable = false)
    private Date fecha;
    @Basic
    @Column(name = "monto", nullable = false, precision = 2)
    private double monto;

    @ManyToOne
    @JoinColumn(name = "idCdp", referencedColumnName = "idCdp", nullable = false)
    private CdpEntity cdpByIdCdp;



}
