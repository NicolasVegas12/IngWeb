package com.nvegas.ingwebapi.models.entities;

import com.nvegas.ingwebapi.models.dto.request.product.UpdateProductRequest;
import com.nvegas.ingwebapi.models.dto.response.product.GetProductResponse;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "producto", schema = "chikitinesbd", catalog = "")
public class ProductoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idProducto", nullable = false)
    private int idProducto;
    @Basic
    @Column(name = "descripcion", nullable = false, length = 50)
    private String descripcion;
    @Basic
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Basic
    @Column(name = "stock", nullable = false)
    private int stock;
    @Basic
    @Column(name = "tipo", nullable = false)
    private int tipo;
    @OneToMany(mappedBy = "productoByProductoIdProducto")
    private Collection<BoletaDetalleEntity> boletaDetallesByIdProducto;
    @OneToMany(mappedBy = "productoByIdProducto")
    private Collection<DetalleNotaIngresoEntity> detalleNotaIngresosByIdProducto;
    @OneToMany(mappedBy = "productoByIdProducto")
    private Collection<DetalleNotaSalidaEntity> detalleNotaSalidasByIdProducto;
    @OneToMany(mappedBy = "productoByProductoIdProducto")
    private Collection<DetallePedidoEntity> detallePedidosByIdProducto;
    @OneToMany(mappedBy = "productoByIdProducto")
    private Collection<DetalleVentaEntity> detalleVentasByIdProducto;
    @OneToMany(mappedBy = "productoByIdProducto")
    private Collection<FacturaDetalleEntity> facturaDetallesByIdProducto;
    @OneToMany(mappedBy = "productoByIdProducto")
    private Collection<RequerimientoDetalleEntity> requerimientoDetallesByIdProducto;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductoEntity that = (ProductoEntity) o;

        if (idProducto != that.idProducto) return false;
        if (nombre != that.nombre) return false;
        if (stock != that.stock) return false;
        if (tipo != that.tipo) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProducto;
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + stock;
        result = 31 * result + tipo;
        return result;
    }

    public Collection<BoletaDetalleEntity> getBoletaDetallesByIdProducto() {
        return boletaDetallesByIdProducto;
    }

    public void setBoletaDetallesByIdProducto(Collection<BoletaDetalleEntity> boletaDetallesByIdProducto) {
        this.boletaDetallesByIdProducto = boletaDetallesByIdProducto;
    }

    public Collection<DetalleNotaIngresoEntity> getDetalleNotaIngresosByIdProducto() {
        return detalleNotaIngresosByIdProducto;
    }

    public void setDetalleNotaIngresosByIdProducto(Collection<DetalleNotaIngresoEntity> detalleNotaIngresosByIdProducto) {
        this.detalleNotaIngresosByIdProducto = detalleNotaIngresosByIdProducto;
    }

    public Collection<DetalleNotaSalidaEntity> getDetalleNotaSalidasByIdProducto() {
        return detalleNotaSalidasByIdProducto;
    }

    public void setDetalleNotaSalidasByIdProducto(Collection<DetalleNotaSalidaEntity> detalleNotaSalidasByIdProducto) {
        this.detalleNotaSalidasByIdProducto = detalleNotaSalidasByIdProducto;
    }

    public Collection<DetallePedidoEntity> getDetallePedidosByIdProducto() {
        return detallePedidosByIdProducto;
    }

    public void setDetallePedidosByIdProducto(Collection<DetallePedidoEntity> detallePedidosByIdProducto) {
        this.detallePedidosByIdProducto = detallePedidosByIdProducto;
    }

    public Collection<DetalleVentaEntity> getDetalleVentasByIdProducto() {
        return detalleVentasByIdProducto;
    }

    public void setDetalleVentasByIdProducto(Collection<DetalleVentaEntity> detalleVentasByIdProducto) {
        this.detalleVentasByIdProducto = detalleVentasByIdProducto;
    }

    public Collection<FacturaDetalleEntity> getFacturaDetallesByIdProducto() {
        return facturaDetallesByIdProducto;
    }

    public void setFacturaDetallesByIdProducto(Collection<FacturaDetalleEntity> facturaDetallesByIdProducto) {
        this.facturaDetallesByIdProducto = facturaDetallesByIdProducto;
    }

    public Collection<RequerimientoDetalleEntity> getRequerimientoDetallesByIdProducto() {
        return requerimientoDetallesByIdProducto;
    }

    public void setRequerimientoDetallesByIdProducto(Collection<RequerimientoDetalleEntity> requerimientoDetallesByIdProducto) {
        this.requerimientoDetallesByIdProducto = requerimientoDetallesByIdProducto;
    }


    public ProductoEntity updateProduct(UpdateProductRequest request){
        setTipo(request.getTipo());
        setStock(request.getStock());
        setDescripcion(request.getDescripcion());
        setNombre(request.getNombre());
        return this;
    }

    public GetProductResponse toResponse(){
        GetProductResponse response = new GetProductResponse();
        response.setDescripcion(this.descripcion);
        response.setStock(this.stock);
        response.setId(this.idProducto);
        response.setTipo(this.tipo);
        response.setNombre(this.nombre);

        return response;
    }
}
