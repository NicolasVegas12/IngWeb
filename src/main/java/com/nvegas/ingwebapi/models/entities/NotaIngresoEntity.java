package com.nvegas.ingwebapi.models.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "nota_ingreso", schema = "chikitinesbd", catalog = "")
public class NotaIngresoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idNotaIngreso", nullable = false)
    private int idNotaIngreso;
    @Basic
    @Column(name = "descripcion", nullable = false, length = 50)
    private String descripcion;
    @Basic
    @Column(name = "fechaIngreso", nullable = false)
    private Date fechaIngreso;

    @OneToMany(mappedBy = "notaIngresoByIdNotaIngreso")
    private Collection<DetalleNotaIngresoEntity> detalleNotaIngresosByIdNotaIngreso;
    @ManyToOne
    @JoinColumn(name = "idJefeAlmacen", referencedColumnName = "idJefeAlmacen", nullable = false)
    private JefeAlmacenEntity jefeAlmacenByIdJefeAlmacen;

    public int getIdNotaIngreso() {
        return idNotaIngreso;
    }

    public void setIdNotaIngreso(int idNotaIngreso) {
        this.idNotaIngreso = idNotaIngreso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NotaIngresoEntity that = (NotaIngresoEntity) o;

        if (idNotaIngreso != that.idNotaIngreso) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (fechaIngreso != null ? !fechaIngreso.equals(that.fechaIngreso) : that.fechaIngreso != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idNotaIngreso;
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (fechaIngreso != null ? fechaIngreso.hashCode() : 0);
        return result;
    }

    public Collection<DetalleNotaIngresoEntity> getDetalleNotaIngresosByIdNotaIngreso() {
        return detalleNotaIngresosByIdNotaIngreso;
    }

    public void setDetalleNotaIngresosByIdNotaIngreso(Collection<DetalleNotaIngresoEntity> detalleNotaIngresosByIdNotaIngreso) {
        this.detalleNotaIngresosByIdNotaIngreso = detalleNotaIngresosByIdNotaIngreso;
    }

    public JefeAlmacenEntity getJefeAlmacenByIdJefeAlmacen() {
        return jefeAlmacenByIdJefeAlmacen;
    }

    public void setJefeAlmacenByIdJefeAlmacen(JefeAlmacenEntity jefeAlmacenByIdJefeAlmacen) {
        this.jefeAlmacenByIdJefeAlmacen = jefeAlmacenByIdJefeAlmacen;
    }
}
