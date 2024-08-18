package com.nvegas.ingwebapi.models.entities;

import com.nvegas.ingwebapi.models.dto.response.cliente.GetJuridicClientResponse;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@Entity
@Table(name = "juridico", schema = "chikitinesbd")
public class JuridicoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idJuridico", nullable = false)
    private int idJuridico;
    @Basic
    @Column(name = "dniRepre", nullable = false, length = 50)
    private String dniRepre;
    @Basic
    @Column(name = "nombreRepre", nullable = false, length = 50)
    private String nombreRepre;
    @Basic
    @Column(name = "ruc", nullable = false, length = 50)
    private String ruc;


    public GetJuridicClientResponse toResponse(){
        GetJuridicClientResponse response = new GetJuridicClientResponse();

        response.setRuc(this.getRuc());
        response.setDniRepre(this.getDniRepre());
        response.setNombreRepre(this.getNombreRepre());
        return response;

    }


}
