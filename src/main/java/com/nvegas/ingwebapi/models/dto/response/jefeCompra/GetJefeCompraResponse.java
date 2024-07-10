package com.nvegas.ingwebapi.models.dto.response.jefeCompra;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

public class GetJefeCompraResponse {

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
