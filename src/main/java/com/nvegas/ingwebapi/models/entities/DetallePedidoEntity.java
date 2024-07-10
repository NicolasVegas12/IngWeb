package com.nvegas.ingwebapi.models.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle_pedido", schema = "chikitinesbd", catalog = "")
public class DetallePedidoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idDetallePedido", nullable = false)
    private int idDetallePedido;
    @Basic
    @Column(name = "monto", nullable = false, precision = 2)
    private double monto;

    @Basic
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @ManyToOne
    @JoinColumn(name = "idPedido", referencedColumnName = "idPedido", nullable = false)
    private PedidoEntity pedidoByPedidoIdPedido;
    @ManyToOne
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto", nullable = false)
    private ProductoEntity productoByProductoIdProducto;

    public int getIdDetallePedido() {
        return idDetallePedido;
    }

    public void setIdDetallePedido(int idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
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

        DetallePedidoEntity that = (DetallePedidoEntity) o;

        if (idDetallePedido != that.idDetallePedido) return false;
        if (Double.compare(that.monto, monto) != 0) return false;
        if (cantidad != that.cantidad) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idDetallePedido;
        temp = Double.doubleToLongBits(monto);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + cantidad;
        return result;
    }

    public PedidoEntity getPedidoByPedidoIdPedido() {
        return pedidoByPedidoIdPedido;
    }

    public void setPedidoByPedidoIdPedido(PedidoEntity pedidoByPedidoIdPedido) {
        this.pedidoByPedidoIdPedido = pedidoByPedidoIdPedido;
    }

    public ProductoEntity getProductoByProductoIdProducto() {
        return productoByProductoIdProducto;
    }

    public void setProductoByProductoIdProducto(ProductoEntity productoByProductoIdProducto) {
        this.productoByProductoIdProducto = productoByProductoIdProducto;
    }
}
