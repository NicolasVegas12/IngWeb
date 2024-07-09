package com.nvegas.ingwebapi.models.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "factura", schema = "chikitinesbd", catalog = "")
public class FacturaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idFactura", nullable = false)
    private int idFactura;
    @Basic
    @Column(name = "estado", nullable = false, length = 50)
    private String estado;
    @Basic
    @Column(name = "fecha", nullable = false)
    private Date fecha;
    @Basic
    @Column(name = "idFacturaDetalle", nullable = false)
    private int idFacturaDetalle;
    @OneToMany(mappedBy = "facturaByIdFactura")
    private Collection<CdpEntity> cdpsByIdFactura;
    @ManyToOne
    @JoinColumn(name = "idFacturaDetalle", referencedColumnName = "idFacturaDetalle", nullable = false)
    private FacturaDetalleEntity facturaDetalleByIdFacturaDetalle;

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdFacturaDetalle() {
        return idFacturaDetalle;
    }

    public void setIdFacturaDetalle(int idFacturaDetalle) {
        this.idFacturaDetalle = idFacturaDetalle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FacturaEntity that = (FacturaEntity) o;

        if (idFactura != that.idFactura) return false;
        if (idFacturaDetalle != that.idFacturaDetalle) return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFactura;
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + idFacturaDetalle;
        return result;
    }

    public Collection<CdpEntity> getCdpsByIdFactura() {
        return cdpsByIdFactura;
    }

    public void setCdpsByIdFactura(Collection<CdpEntity> cdpsByIdFactura) {
        this.cdpsByIdFactura = cdpsByIdFactura;
    }

    public FacturaDetalleEntity getFacturaDetalleByIdFacturaDetalle() {
        return facturaDetalleByIdFacturaDetalle;
    }

    public void setFacturaDetalleByIdFacturaDetalle(FacturaDetalleEntity facturaDetalleByIdFacturaDetalle) {
        this.facturaDetalleByIdFacturaDetalle = facturaDetalleByIdFacturaDetalle;
    }
}
