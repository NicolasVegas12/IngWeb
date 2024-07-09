package com.nvegas.ingwebapi.models.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "requerimiento_detalle", schema = "chikitinesbd", catalog = "")
public class RequerimientoDetalleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idRequerimientoDetalle", nullable = false)
    private int idRequerimientoDetalle;
    @Basic
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @Basic
    @Column(name = "idRequerimiento", nullable = false)
    private int idRequerimiento;
    @Basic
    @Column(name = "idProducto", nullable = false)
    private int idProducto;
    @ManyToOne
    @JoinColumn(name = "idRequerimiento", referencedColumnName = "idRequerimiento", nullable = false)
    private RequerimientoEntity requerimientoByIdRequerimiento;
    @ManyToOne
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto", nullable = false)
    private ProductoEntity productoByIdProducto;

    public int getIdRequerimientoDetalle() {
        return idRequerimientoDetalle;
    }

    public void setIdRequerimientoDetalle(int idRequerimientoDetalle) {
        this.idRequerimientoDetalle = idRequerimientoDetalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdRequerimiento() {
        return idRequerimiento;
    }

    public void setIdRequerimiento(int idRequerimiento) {
        this.idRequerimiento = idRequerimiento;
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

        RequerimientoDetalleEntity that = (RequerimientoDetalleEntity) o;

        if (idRequerimientoDetalle != that.idRequerimientoDetalle) return false;
        if (cantidad != that.cantidad) return false;
        if (idRequerimiento != that.idRequerimiento) return false;
        if (idProducto != that.idProducto) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRequerimientoDetalle;
        result = 31 * result + cantidad;
        result = 31 * result + idRequerimiento;
        result = 31 * result + idProducto;
        return result;
    }

    public RequerimientoEntity getRequerimientoByIdRequerimiento() {
        return requerimientoByIdRequerimiento;
    }

    public void setRequerimientoByIdRequerimiento(RequerimientoEntity requerimientoByIdRequerimiento) {
        this.requerimientoByIdRequerimiento = requerimientoByIdRequerimiento;
    }

    public ProductoEntity getProductoByIdProducto() {
        return productoByIdProducto;
    }

    public void setProductoByIdProducto(ProductoEntity productoByIdProducto) {
        this.productoByIdProducto = productoByIdProducto;
    }
}
