package com.nvegas.ingwebapi.models.dto.request.proveedor;

import com.nvegas.ingwebapi.models.entities.ProveedorEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;

public class SaveProveedorRequest {

    public SaveProveedorRequest(String nombre, String dni, String telefono) {
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
    }

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

    public ProveedorEntity toEntity() {
        ProveedorEntity entity = new ProveedorEntity();
        entity.setTelefono(this.getTelefono());
        entity.setNombre(this.getNombre());
        entity.setDni(this.getDni());
        entity.setEstado(Boolean.TRUE);
        entity.setPedidosByIdProveedor(Collections.emptyList());

        return entity;
    }
}
