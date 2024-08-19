package com.nvegas.ingwebapi.models.entities;

import com.nvegas.ingwebapi.models.dto.request.product.UpdateProductRequest;
import com.nvegas.ingwebapi.models.dto.response.product.GetProductResponse;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@Entity
@Table(name = "producto", schema = "chikitinesbd")
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

    @Basic
    @Column(name = "precio", nullable = false)
    private double precio;

    @OneToMany(mappedBy = "productoByIdProducto")
    private Collection<BoletaDetalleEntity> boletaDetallesByIdProducto;
    @OneToMany(mappedBy = "productoByIdProducto")
    private Collection<DetalleNotaIngresoEntity> detalleNotaIngresosByIdProducto;
    @OneToMany(mappedBy = "productoByIdProducto")
    private Collection<DetalleNotaSalidaEntity> detalleNotaSalidasByIdProducto;
    @OneToMany(mappedBy = "productoByIdProducto")
    private Collection<DetallePedidoEntity> detallePedidosByIdProducto;
    @OneToMany(mappedBy = "productoByIdProducto")
    private Collection<DetalleVentaEntity> detalleVentasByIdProducto;
    @OneToMany(mappedBy = "productoByIdProducto")
    private Collection<FacturaDetalleEntity> facturaDetallesByIdProducto;
    @OneToMany(mappedBy = "productoByIdProducto")
    private Collection<RequerimientoDetalleEntity> requerimientoDetallesByIdProducto;



    public ProductoEntity updateProduct(UpdateProductRequest request){
        setTipo(request.getTipo());
        setStock(request.getStock());
        setDescripcion(request.getDescripcion());
        setNombre(request.getNombre());
        setPrecio(request.getPrecio());
        return this;
    }

    public GetProductResponse toResponse(){
        GetProductResponse response = new GetProductResponse();
        response.setDescripcion(this.descripcion);
        response.setStock(this.stock);
        response.setId(this.idProducto);
        response.setTipo(this.tipo);
        response.setNombre(this.nombre);
        response.setPrecio(this.precio);
        return response;
    }
}
