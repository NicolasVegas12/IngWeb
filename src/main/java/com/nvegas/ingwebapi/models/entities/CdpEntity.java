package com.nvegas.ingwebapi.models.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "cdp", schema = "chikitinesbd", catalog = "")
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
    @Basic
    @Column(name = "idBoleta", nullable = true)
    private Integer idBoleta;
    @Basic
    @Column(name = "idFactura", nullable = true)
    private Integer idFactura;
    @Basic
    @Column(name = "idVenta", nullable = false)
    private int idVenta;
    @ManyToOne
    @JoinColumn(name = "idBoleta", referencedColumnName = "idBoleta")
    private BoletaEntity boletaByIdBoleta;
    @ManyToOne
    @JoinColumn(name = "idFactura", referencedColumnName = "idFactura")
    private FacturaEntity facturaByIdFactura;
    @ManyToOne
    @JoinColumn(name = "idVenta", referencedColumnName = "idVenta", nullable = false)
    private VentaEntity ventaByIdVenta;
    @OneToMany(mappedBy = "cdpByIdCdp")
    private Collection<PagoEntity> pagosByIdCdp;

    public int getIdCdp() {
        return idCdp;
    }

    public void setIdCdp(int idCdp) {
        this.idCdp = idCdp;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Integer getIdBoleta() {
        return idBoleta;
    }

    public void setIdBoleta(Integer idBoleta) {
        this.idBoleta = idBoleta;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CdpEntity cdpEntity = (CdpEntity) o;

        if (idCdp != cdpEntity.idCdp) return false;
        if (Double.compare(cdpEntity.monto, monto) != 0) return false;
        if (idVenta != cdpEntity.idVenta) return false;
        if (fecha != null ? !fecha.equals(cdpEntity.fecha) : cdpEntity.fecha != null) return false;
        if (idBoleta != null ? !idBoleta.equals(cdpEntity.idBoleta) : cdpEntity.idBoleta != null) return false;
        if (idFactura != null ? !idFactura.equals(cdpEntity.idFactura) : cdpEntity.idFactura != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idCdp;
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        temp = Double.doubleToLongBits(monto);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (idBoleta != null ? idBoleta.hashCode() : 0);
        result = 31 * result + (idFactura != null ? idFactura.hashCode() : 0);
        result = 31 * result + idVenta;
        return result;
    }

    public BoletaEntity getBoletaByIdBoleta() {
        return boletaByIdBoleta;
    }

    public void setBoletaByIdBoleta(BoletaEntity boletaByIdBoleta) {
        this.boletaByIdBoleta = boletaByIdBoleta;
    }

    public FacturaEntity getFacturaByIdFactura() {
        return facturaByIdFactura;
    }

    public void setFacturaByIdFactura(FacturaEntity facturaByIdFactura) {
        this.facturaByIdFactura = facturaByIdFactura;
    }

    public VentaEntity getVentaByIdVenta() {
        return ventaByIdVenta;
    }

    public void setVentaByIdVenta(VentaEntity ventaByIdVenta) {
        this.ventaByIdVenta = ventaByIdVenta;
    }

    public Collection<PagoEntity> getPagosByIdCdp() {
        return pagosByIdCdp;
    }

    public void setPagosByIdCdp(Collection<PagoEntity> pagosByIdCdp) {
        this.pagosByIdCdp = pagosByIdCdp;
    }
}
