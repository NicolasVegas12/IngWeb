package com.nvegas.ingwebapi.models.dto.response.proveedor;

import lombok.Getter;
import lombok.Setter;

public class GetProveedorResponse {

    @Getter
    @Setter

    private int idProveedor;
    @Getter
    @Setter
    private String nombre;
    @Getter
    @Setter
    private String dni;

    @Getter
    @Setter
    private String telefono;


    @Getter
    @Setter
    private Integer idJefeCompras;
}
