package com.nvegas.ingwebapi.models.dto.request.cliente;

import com.nvegas.ingwebapi.models.entities.ClienteEntity;
import com.nvegas.ingwebapi.models.entities.NaturalEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveClienteNaturalRequest {
    private String nombreCliente;

    private String email;

    private String telefono;

    private String direccion;
    private Integer idVendedor;
    private String dni;

    public NaturalEntity toNaturalEntity(){
        NaturalEntity entity = new NaturalEntity();
        entity.setDni(this.getDni());
        return entity;
    }

    public ClienteEntity toEntity(){
        ClienteEntity entity = new ClienteEntity();
        entity.setTelefono(this.getTelefono());
        entity.setDireccion(this.getDireccion());
        entity.setNombreCliente(this.getNombreCliente());
        entity.setEmail(this.getEmail());
        return entity;
    }
}
