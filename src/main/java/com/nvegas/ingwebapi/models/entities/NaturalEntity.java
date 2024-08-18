package com.nvegas.ingwebapi.models.entities;

import com.nvegas.ingwebapi.models.dto.response.cliente.GetNaturalClientResponse;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@Entity
@Table(name = "naturalClient", schema = "chikitinesbd")
public class NaturalEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idNatural", nullable = false)
    private int idNatural;
    @Basic
    @Column(name = "dni", nullable = false, length = 50)
    private String dni;

    public GetNaturalClientResponse toResponse(){
        GetNaturalClientResponse response = new GetNaturalClientResponse();
        response.setDni(this.getDni());
        return response;
    }

}
