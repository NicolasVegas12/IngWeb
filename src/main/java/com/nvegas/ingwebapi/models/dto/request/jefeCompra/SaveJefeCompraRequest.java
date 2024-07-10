package com.nvegas.ingwebapi.models.dto.request.jefeCompra;

import com.nvegas.ingwebapi.models.entities.JefeComprasEntity;
import com.nvegas.ingwebapi.models.entities.ProductoEntity;
import lombok.Getter;
import lombok.Setter;

public class SaveJefeCompraRequest {

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
    private String direccion;


    public JefeComprasEntity toEntity() {
        JefeComprasEntity entity = new JefeComprasEntity();
        entity.setNombre(this.getNombre());
        entity.setDni(this.getDni());
        entity.setTelefono(this.getTelefono());
        entity.setDireccion(this.getDireccion());
        return entity;
    }
}
