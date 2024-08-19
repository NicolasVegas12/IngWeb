package com.nvegas.ingwebapi.models.entities;

import com.nvegas.ingwebapi.models.dto.response.venta.GetDetalleVentaResponse;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "detalle_venta", schema = "chikitinesbd")
public class DetalleVentaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idDetalleVenta", nullable = false)
    private int idDetalleVenta;
    @Basic
    @Column(name = "monto", nullable = false, precision = 2)
    private double monto;
    @Basic
    @Column(name = "montoUnitario", nullable = false, precision = 2)
    private double montoUnitario;

    @Basic
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @ManyToOne
    @JoinColumn(name = "idVenta", referencedColumnName = "idVenta", nullable = false)
    private VentaEntity ventaByIdVenta;
    @ManyToOne
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto", nullable = false)
    private ProductoEntity productoByIdProducto;




    public GetDetalleVentaResponse toResponse(){
        GetDetalleVentaResponse response = new GetDetalleVentaResponse();
        response.setIdProducto(this.getProductoByIdProducto().getIdProducto());
        response.setProducto(this.getProductoByIdProducto().getNombre());
        response.setMontoUnitario(this.getMontoUnitario());
        response.setMonto(this.getMonto());
        response.setCantidad(this.getCantidad());
        return response;
    }

}
