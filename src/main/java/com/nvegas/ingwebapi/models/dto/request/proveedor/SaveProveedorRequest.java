package com.nvegas.ingwebapi.models.dto.request.proveedor;

import com.nvegas.ingwebapi.models.entities.ProductoEntity;
import com.nvegas.ingwebapi.models.entities.ProveedorEntity;
import lombok.Getter;
import lombok.Setter;

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

    public ProveedorEntity toEntity() {
        ProveedorEntity entity = new ProveedorEntity();
        entity.setTelefono(this.getTelefono());
        entity.setNombre(this.getNombre());
        entity.setDni(this.getDni());
        return entity;
    }
}
