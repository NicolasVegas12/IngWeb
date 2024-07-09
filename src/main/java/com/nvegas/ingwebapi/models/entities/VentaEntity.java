package com.nvegas.ingwebapi.models.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "venta", schema = "chikitinesbd", catalog = "")
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
    @Column(name = "estado", nullable = false, length = 50)
    private String estado;
    @OneToMany(mappedBy = "ventaByIdVenta")
    private Collection<CdpEntity> cdpsByIdVenta;
    @OneToMany(mappedBy = "ventaByIdVenta")
    private Collection<DetalleVentaEntity> detalleVentasByIdVenta;

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getNroVenta() {
        return nroVenta;
    }

    public void setNroVenta(String nroVenta) {
        this.nroVenta = nroVenta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VentaEntity that = (VentaEntity) o;

        if (idVenta != that.idVenta) return false;
        if (nroVenta != null ? !nroVenta.equals(that.nroVenta) : that.nroVenta != null) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idVenta;
        result = 31 * result + (nroVenta != null ? nroVenta.hashCode() : 0);
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        return result;
    }

    public Collection<CdpEntity> getCdpsByIdVenta() {
        return cdpsByIdVenta;
    }

    public void setCdpsByIdVenta(Collection<CdpEntity> cdpsByIdVenta) {
        this.cdpsByIdVenta = cdpsByIdVenta;
    }

    public Collection<DetalleVentaEntity> getDetalleVentasByIdVenta() {
        return detalleVentasByIdVenta;
    }

    public void setDetalleVentasByIdVenta(Collection<DetalleVentaEntity> detalleVentasByIdVenta) {
        this.detalleVentasByIdVenta = detalleVentasByIdVenta;
    }
}
