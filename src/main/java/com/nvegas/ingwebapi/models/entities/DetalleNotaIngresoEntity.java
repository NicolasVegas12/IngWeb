package com.nvegas.ingwebapi.models.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle_nota_ingreso", schema = "chikitinesbd", catalog = "")
public class DetalleNotaIngresoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idDetalleNotaIngreso", nullable = false)
    private int idDetalleNotaIngreso;
    @Basic
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @Basic
    @Column(name = "idNotaIngreso", nullable = false)
    private int idNotaIngreso;
    @Basic
    @Column(name = "idProducto", nullable = false)
    private int idProducto;
    @ManyToOne
    @JoinColumn(name = "idNotaIngreso", referencedColumnName = "idNotaIngreso", nullable = false)
    private NotaIngresoEntity notaIngresoByIdNotaIngreso;
    @ManyToOne
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto", nullable = false)
    private ProductoEntity productoByIdProducto;

    public int getIdDetalleNotaIngreso() {
        return idDetalleNotaIngreso;
    }

    public void setIdDetalleNotaIngreso(int idDetalleNotaIngreso) {
        this.idDetalleNotaIngreso = idDetalleNotaIngreso;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdNotaIngreso() {
        return idNotaIngreso;
    }

    public void setIdNotaIngreso(int idNotaIngreso) {
        this.idNotaIngreso = idNotaIngreso;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DetalleNotaIngresoEntity that = (DetalleNotaIngresoEntity) o;

        if (idDetalleNotaIngreso != that.idDetalleNotaIngreso) return false;
        if (cantidad != that.cantidad) return false;
        if (idNotaIngreso != that.idNotaIngreso) return false;
        if (idProducto != that.idProducto) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDetalleNotaIngreso;
        result = 31 * result + cantidad;
        result = 31 * result + idNotaIngreso;
        result = 31 * result + idProducto;
        return result;
    }

    public NotaIngresoEntity getNotaIngresoByIdNotaIngreso() {
        return notaIngresoByIdNotaIngreso;
    }

    public void setNotaIngresoByIdNotaIngreso(NotaIngresoEntity notaIngresoByIdNotaIngreso) {
        this.notaIngresoByIdNotaIngreso = notaIngresoByIdNotaIngreso;
    }

    public ProductoEntity getProductoByIdProducto() {
        return productoByIdProducto;
    }

    public void setProductoByIdProducto(ProductoEntity productoByIdProducto) {
        this.productoByIdProducto = productoByIdProducto;
    }
}
