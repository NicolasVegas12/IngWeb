package com.nvegas.ingwebapi.models.dto.request.product;

import com.nvegas.ingwebapi.models.entities.ProductoEntity;
import lombok.Getter;
import lombok.Setter;

public class UpdateProductRequest {

    public UpdateProductRequest(int id, String descripcion, String nombre, int stock, int tipo) {
        this.id = id;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.stock = stock;
        this.tipo = tipo;
    }

    @Getter
    @Setter
    private int id;

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

    @Getter
    @Setter
    private double precio;


}
