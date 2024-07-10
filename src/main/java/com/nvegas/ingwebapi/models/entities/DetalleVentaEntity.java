package com.nvegas.ingwebapi.models.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle_venta", schema = "chikitinesbd", catalog = "")
public class DetalleVentaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idDetalleVenta", nullable = false)
    private int idDetalleVenta;
    @Basic
    @Column(name = "monto", nullable = false, precision = 2)
    private double monto;

    @Basic
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @ManyToOne
    @JoinColumn(name = "idVenta", referencedColumnName = "idVenta", nullable = false)
    private VentaEntity ventaByIdVenta;
    @ManyToOne
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto", nullable = false)
    private ProductoEntity productoByIdProducto;

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
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

        DetalleVentaEntity that = (DetalleVentaEntity) o;

        if (idDetalleVenta != that.idDetalleVenta) return false;
        if (Double.compare(that.monto, monto) != 0) return false;
        if (cantidad != that.cantidad) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idDetalleVenta;
        temp = Double.doubleToLongBits(monto);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + cantidad;
        return result;
    }

    public VentaEntity getVentaByIdVenta() {
        return ventaByIdVenta;
    }

    public void setVentaByIdVenta(VentaEntity ventaByIdVenta) {
        this.ventaByIdVenta = ventaByIdVenta;
    }

    public ProductoEntity getProductoByIdProducto() {
        return productoByIdProducto;
    }

    public void setProductoByIdProducto(ProductoEntity productoByIdProducto) {
        this.productoByIdProducto = productoByIdProducto;
    }
}
