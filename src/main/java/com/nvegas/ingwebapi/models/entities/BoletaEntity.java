package com.nvegas.ingwebapi.models.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "boleta", schema = "chikitinesbd", catalog = "")
public class BoletaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idBoleta", nullable = false)
    private int idBoleta;
    @Basic
    @Column(name = "fecha", nullable = false)
    private Date fecha;
    @Basic
    @Column(name = "estado", nullable = false, length = 50)
    private String estado;
    @Basic
    @Column(name = "idBoletaDetalle", nullable = false)
    private int idBoletaDetalle;
    @ManyToOne
    @JoinColumn(name = "idBoletaDetalle", referencedColumnName = "idBoletaDetalle", nullable = false)
    private BoletaDetalleEntity boletaDetalleByIdBoletaDetalle;
    @OneToMany(mappedBy = "boletaByIdBoleta")
    private Collection<CdpEntity> cdpsByIdBoleta;

    public int getIdBoleta() {
        return idBoleta;
    }

    public void setIdBoleta(int idBoleta) {
        this.idBoleta = idBoleta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdBoletaDetalle() {
        return idBoletaDetalle;
    }

    public void setIdBoletaDetalle(int idBoletaDetalle) {
        this.idBoletaDetalle = idBoletaDetalle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BoletaEntity that = (BoletaEntity) o;

        if (idBoleta != that.idBoleta) return false;
        if (idBoletaDetalle != that.idBoletaDetalle) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idBoleta;
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + idBoletaDetalle;
        return result;
    }

    public BoletaDetalleEntity getBoletaDetalleByIdBoletaDetalle() {
        return boletaDetalleByIdBoletaDetalle;
    }

    public void setBoletaDetalleByIdBoletaDetalle(BoletaDetalleEntity boletaDetalleByIdBoletaDetalle) {
        this.boletaDetalleByIdBoletaDetalle = boletaDetalleByIdBoletaDetalle;
    }

    public Collection<CdpEntity> getCdpsByIdBoleta() {
        return cdpsByIdBoleta;
    }

    public void setCdpsByIdBoleta(Collection<CdpEntity> cdpsByIdBoleta) {
        this.cdpsByIdBoleta = cdpsByIdBoleta;
    }
}
