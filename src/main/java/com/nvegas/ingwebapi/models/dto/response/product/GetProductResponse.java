package com.nvegas.ingwebapi.models.dto.response.product;

import lombok.Getter;
import lombok.Setter;

public class GetProductResponse {

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


}
