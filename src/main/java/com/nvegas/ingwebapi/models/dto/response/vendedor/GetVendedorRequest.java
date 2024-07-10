package com.nvegas.ingwebapi.models.dto.response.vendedor;

import lombok.Getter;
import lombok.Setter;

public class GetVendedorRequest {



    @Getter
    @Setter
    private int idVendedor;
    @Getter
    @Setter
    private String nombre;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String telefono;
    @Getter
    @Setter
    private String direccion;
}
