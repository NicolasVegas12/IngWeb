package com.nvegas.ingwebapi.models.dto.request.vendedor;

import lombok.Getter;
import lombok.Setter;

public class UpdateVendedorRequest {

    public UpdateVendedorRequest(int idVendedor, String nombre, String email, String telefono, String direccion) {
        this.idVendedor = idVendedor;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
    }

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
