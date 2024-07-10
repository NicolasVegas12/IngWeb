package com.nvegas.ingwebapi.models.dto.request.product;


import com.nvegas.ingwebapi.models.entities.ProductoEntity;
import lombok.Getter;
import lombok.Setter;

public class SaveProductRequest {
    public SaveProductRequest(String descripcion, String nombre, int stock, int tipo) {
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.stock = stock;
        this.tipo = tipo;
    }

    @Getter
    @Setter

    private String descripcion;
    @Getter
    @Setter
    private String nombre;
    @Getter
    @Setter
    private int stock;
    @Getter
    @Setter
    private int tipo;

    public ProductoEntity toEntity() {
        ProductoEntity entity = new ProductoEntity();
        entity.setDescripcion(this.getDescripcion());
        entity.setNombre(this.getNombre());
        entity.setStock(this.getStock());
        entity.setTipo(this.getTipo());
        return entity;
    }
}
