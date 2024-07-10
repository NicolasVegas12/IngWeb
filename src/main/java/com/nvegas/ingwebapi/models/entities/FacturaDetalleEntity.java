package com.nvegas.ingwebapi.models.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "factura_detalle", schema = "chikitinesbd", catalog = "")
public class FacturaDetalleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idFacturaDetalle", nullable = false)
    private int idFacturaDetalle;
    @Basic
    @Column(name = "monto", nullable = false, precision = 2)
    private double monto;

    @Basic
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @OneToMany(mappedBy = "facturaDetalleByIdFacturaDetalle")
    private Collection<FacturaEntity> facturasByIdFacturaDetalle;
    @ManyToOne
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto", nullable = false)
    private ProductoEntity productoByIdProducto;

    public int getIdFacturaDetalle() {
        return idFacturaDetalle;
    }

    public void setIdFacturaDetalle(int idFacturaDetalle) {
        this.idFacturaDetalle = idFacturaDetalle;
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

        FacturaDetalleEntity that = (FacturaDetalleEntity) o;

        if (idFacturaDetalle != that.idFacturaDetalle) return false;
        if (Double.compare(that.monto, monto) != 0) return false;
        if (cantidad != that.cantidad) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idFacturaDetalle;
        temp = Double.doubleToLongBits(monto);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + cantidad;
        return result;
    }

    public Collection<FacturaEntity> getFacturasByIdFacturaDetalle() {
        return facturasByIdFacturaDetalle;
    }

    public void setFacturasByIdFacturaDetalle(Collection<FacturaEntity> facturasByIdFacturaDetalle) {
        this.facturasByIdFacturaDetalle = facturasByIdFacturaDetalle;
    }

    public ProductoEntity getProductoByIdProducto() {
        return productoByIdProducto;
    }

    public void setProductoByIdProducto(ProductoEntity productoByIdProducto) {
        this.productoByIdProducto = productoByIdProducto;
    }
}
