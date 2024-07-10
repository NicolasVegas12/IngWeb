package com.nvegas.ingwebapi.models.dto.request.vendedor;

import com.nvegas.ingwebapi.models.entities.ProveedorEntity;
import com.nvegas.ingwebapi.models.entities.VendedorEntity;
import lombok.Getter;
import lombok.Setter;

public class SaveVendedorRequest {

    public SaveVendedorRequest(String nombre, String email, String telefono, String direccion) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
    }

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

    public VendedorEntity toEntity() {
        VendedorEntity entity = new VendedorEntity();
        entity.setNombre(this.getNombre());
        entity.setEmail(this.getEmail());
        entity.setTelefono(this.getTelefono());
        entity.setDireccion(this.getDireccion());
        return entity;
    }
}
