package com.nvegas.ingwebapi.models.dto.request.jefeCompra;

import lombok.Getter;
import lombok.Setter;

public class UpdateJefeCompraRequest {
    @Getter
    @Setter
    private int idJefeCompras;
    @Getter
    @Setter
    private String nombre;
    @Getter
    @Setter
    private String dni;
    @Getter
    @Setter
    private String estado;
    @Getter
    @Setter
    private String telefono;
    @Getter
    @Setter
    private String direccion;
}
