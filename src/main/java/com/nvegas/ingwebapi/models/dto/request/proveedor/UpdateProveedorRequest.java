package com.nvegas.ingwebapi.models.dto.request.proveedor;


import lombok.Getter;
import lombok.Setter;

public class UpdateProveedorRequest {

    public UpdateProveedorRequest(int idProveedor, String nombre, String dni, String telefono) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
    }

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


}
