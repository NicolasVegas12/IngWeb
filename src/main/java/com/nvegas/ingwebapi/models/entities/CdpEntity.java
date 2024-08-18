package com.nvegas.ingwebapi.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.Collection;

@Getter
@Setter
@Entity
@Table(name = "cdp", schema = "chikitinesbd")
public class CdpEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idCdp", nullable = false)
    private int idCdp;
    @Basic
    @Column(name = "fecha", nullable = false)
    private Date fecha;
    @Basic
    @Column(name = "monto", nullable = false, precision = 2)
    private double monto;

    @ManyToOne
    @JoinColumn(name = "idBoleta", referencedColumnName = "idBoleta")
    private BoletaEntity boletaByIdBoleta;
    @ManyToOne
    @JoinColumn(name = "idFactura", referencedColumnName = "idFactura")
    private FacturaEntity facturaByIdFactura;

    @OneToMany(mappedBy = "cdpByIdCdp")
    private Collection<PagoEntity> pagosByIdCdp;


}
