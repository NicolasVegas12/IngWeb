package com.nvegas.ingwebapi.models.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "requerimiento", schema = "chikitinesbd", catalog = "")
public class RequerimientoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idRequerimiento", nullable = false)
    private int idRequerimiento;
    @Basic
    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "idJefeAlmacen", referencedColumnName = "idJefeAlmacen", nullable = false)
    private JefeAlmacenEntity jefeAlmacenByIdJefeAlmacen;
    @ManyToOne
    @JoinColumn(name = "idJefeCompras", referencedColumnName = "idJefeCompras", nullable = false)
    private JefeComprasEntity jefeComprasByIdJefeCompras;
    @OneToMany(mappedBy = "requerimientoByIdRequerimiento")
    private Collection<RequerimientoDetalleEntity> requerimientoDetallesByIdRequerimiento;

    public int getIdRequerimiento() {
        return idRequerimiento;
    }

    public void setIdRequerimiento(int idRequerimiento) {
        this.idRequerimiento = idRequerimiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RequerimientoEntity that = (RequerimientoEntity) o;

        if (idRequerimiento != that.idRequerimiento) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRequerimiento;
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        return result;
    }

    public JefeAlmacenEntity getJefeAlmacenByIdJefeAlmacen() {
        return jefeAlmacenByIdJefeAlmacen;
    }

    public void setJefeAlmacenByIdJefeAlmacen(JefeAlmacenEntity jefeAlmacenByIdJefeAlmacen) {
        this.jefeAlmacenByIdJefeAlmacen = jefeAlmacenByIdJefeAlmacen;
    }

    public JefeComprasEntity getJefeComprasByIdJefeCompras() {
        return jefeComprasByIdJefeCompras;
    }

    public void setJefeComprasByIdJefeCompras(JefeComprasEntity jefeComprasByIdJefeCompras) {
        this.jefeComprasByIdJefeCompras = jefeComprasByIdJefeCompras;
    }

    public Collection<RequerimientoDetalleEntity> getRequerimientoDetallesByIdRequerimiento() {
        return requerimientoDetallesByIdRequerimiento;
    }

    public void setRequerimientoDetallesByIdRequerimiento(Collection<RequerimientoDetalleEntity> requerimientoDetallesByIdRequerimiento) {
        this.requerimientoDetallesByIdRequerimiento = requerimientoDetallesByIdRequerimiento;
    }
}
