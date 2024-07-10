package com.nvegas.ingwebapi.models.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "nota_salida", schema = "chikitinesbd", catalog = "")
public class NotaSalidaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idNotaSalida", nullable = false)
    private int idNotaSalida;
    @Basic
    @Column(name = "descripcion", nullable = false, length = 50)
    private String descripcion;
    @Basic
    @Column(name = "fechaSalida", nullable = false)
    private Date fechaSalida;

    @OneToMany(mappedBy = "notaSalidaByIdNotaSalida")
    private Collection<DetalleNotaSalidaEntity> detalleNotaSalidasByIdNotaSalida;
    @ManyToOne
    @JoinColumn(name = "idJefeAlmacen", referencedColumnName = "idJefeAlmacen", nullable = false)
    private JefeAlmacenEntity jefeAlmacenByIdJefeAlmacen;

    public int getIdNotaSalida() {
        return idNotaSalida;
    }

    public void setIdNotaSalida(int idNotaSalida) {
        this.idNotaSalida = idNotaSalida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NotaSalidaEntity that = (NotaSalidaEntity) o;

        if (idNotaSalida != that.idNotaSalida) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (fechaSalida != null ? !fechaSalida.equals(that.fechaSalida) : that.fechaSalida != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idNotaSalida;
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (fechaSalida != null ? fechaSalida.hashCode() : 0);
        return result;
    }

    public Collection<DetalleNotaSalidaEntity> getDetalleNotaSalidasByIdNotaSalida() {
        return detalleNotaSalidasByIdNotaSalida;
    }

    public void setDetalleNotaSalidasByIdNotaSalida(Collection<DetalleNotaSalidaEntity> detalleNotaSalidasByIdNotaSalida) {
        this.detalleNotaSalidasByIdNotaSalida = detalleNotaSalidasByIdNotaSalida;
    }

    public JefeAlmacenEntity getJefeAlmacenByIdJefeAlmacen() {
        return jefeAlmacenByIdJefeAlmacen;
    }

    public void setJefeAlmacenByIdJefeAlmacen(JefeAlmacenEntity jefeAlmacenByIdJefeAlmacen) {
        this.jefeAlmacenByIdJefeAlmacen = jefeAlmacenByIdJefeAlmacen;
    }
}
