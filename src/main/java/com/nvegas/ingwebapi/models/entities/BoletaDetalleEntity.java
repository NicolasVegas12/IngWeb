package com.nvegas.ingwebapi.models.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "boleta_detalle", schema = "chikitinesbd", catalog = "")
public class BoletaDetalleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idBoletaDetalle", nullable = false)
    private int idBoletaDetalle;
    @Basic
    @Column(name = "monto", nullable = false, precision = 2)
    private double monto;

    @Basic
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @OneToMany(mappedBy = "boletaDetalleByIdBoletaDetalle")
    private Collection<BoletaEntity> boletasByIdBoletaDetalle;
    @ManyToOne
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto", nullable = false)
    private ProductoEntity productoByProductoIdProducto;

    public int getIdBoletaDetalle() {
        return idBoletaDetalle;
    }

    public void setIdBoletaDetalle(int idBoletaDetalle) {
        this.idBoletaDetalle = idBoletaDetalle;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }


    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BoletaDetalleEntity that = (BoletaDetalleEntity) o;

        if (idBoletaDetalle != that.idBoletaDetalle) return false;
        if (Double.compare(that.monto, monto) != 0) return false;
        if (cantidad != that.cantidad) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idBoletaDetalle;
        temp = Double.doubleToLongBits(monto);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + cantidad;
        return result;
    }

    public Collection<BoletaEntity> getBoletasByIdBoletaDetalle() {
        return boletasByIdBoletaDetalle;
    }

    public void setBoletasByIdBoletaDetalle(Collection<BoletaEntity> boletasByIdBoletaDetalle) {
        this.boletasByIdBoletaDetalle = boletasByIdBoletaDetalle;
    }

    public ProductoEntity getProductoByProductoIdProducto() {
        return productoByProductoIdProducto;
    }

    public void setProductoByProductoIdProducto(ProductoEntity productoByProductoIdProducto) {
        this.productoByProductoIdProducto = productoByProductoIdProducto;
    }
}
