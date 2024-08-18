package com.nvegas.ingwebapi.models.dto.request.cliente;

import com.nvegas.ingwebapi.models.entities.ClienteEntity;
import com.nvegas.ingwebapi.models.entities.JuridicoEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveClienteJuridicoRequest {
    private String nombreCliente;

    private String email;

    private String telefono;

    private String direccion;

    private Integer idVendedor;

    private String dniRepre;

    private String nombreRepre;

    private String ruc;

    public JuridicoEntity toJuridicoEntity(){
        JuridicoEntity entity = new JuridicoEntity();
        entity.setRuc( this.getRuc());
        entity.setDniRepre(this.getDniRepre());
        entity.setNombreRepre(this.getNombreRepre());
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
