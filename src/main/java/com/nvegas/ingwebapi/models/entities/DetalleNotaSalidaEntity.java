package com.nvegas.ingwebapi.models.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle_nota_salida", schema = "chikitinesbd", catalog = "")
public class DetalleNotaSalidaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idDetalleNotaSalida", nullable = false)
    private int idDetalleNotaSalida;
    @Basic
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @Basic
    @Column(name = "idNotaSalida", nullable = false)
    private int idNotaSalida;
    @Basic
    @Column(name = "idProducto", nullable = false)
    private int idProducto;
    @ManyToOne
    @JoinColumn(name = "idNotaSalida_fk", referencedColumnName = "idNotaSalida", nullable = false)
    private NotaSalidaEntity notaSalidaByIdNotaSalida;
    @ManyToOne
    @JoinColumn(name = "idProducto_fk", referencedColumnName = "idProducto", nullable = false)
    private ProductoEntity productoByIdProducto;

    public int getIdDetalleNotaSalida() {
        return idDetalleNotaSalida;
    }

    public void setIdDetalleNotaSalida(int idDetalleNotaSalida) {
        this.idDetalleNotaSalida = idDetalleNotaSalida;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdNotaSalida() {
        return idNotaSalida;
    }

    public void setIdNotaSalida(int idNotaSalida) {
        this.idNotaSalida = idNotaSalida;
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

        DetalleNotaSalidaEntity that = (DetalleNotaSalidaEntity) o;

        if (idDetalleNotaSalida != that.idDetalleNotaSalida) return false;
        if (cantidad != that.cantidad) return false;
        if (idNotaSalida != that.idNotaSalida) return false;
        if (idProducto != that.idProducto) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDetalleNotaSalida;
        result = 31 * result + cantidad;
        result = 31 * result + idNotaSalida;
        result = 31 * result + idProducto;
        return result;
    }

    public NotaSalidaEntity getNotaSalidaByIdNotaSalida() {
        return notaSalidaByIdNotaSalida;
    }

    public void setNotaSalidaByIdNotaSalida(NotaSalidaEntity notaSalidaByIdNotaSalida) {
        this.notaSalidaByIdNotaSalida = notaSalidaByIdNotaSalida;
    }

    public ProductoEntity getProductoByIdProducto() {
        return productoByIdProducto;
    }

    public void setProductoByIdProducto(ProductoEntity productoByIdProducto) {
        this.productoByIdProducto = productoByIdProducto;
    }
}
