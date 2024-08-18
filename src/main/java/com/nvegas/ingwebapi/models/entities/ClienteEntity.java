package com.nvegas.ingwebapi.models.entities;

import com.nvegas.ingwebapi.models.dto.response.cliente.GetClientResponse;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
@Getter
@Setter
@Entity
@Table(name = "cliente", schema = "chikitinesbd")
public class ClienteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idCliente", nullable = false)
    private int idCliente;
    @Basic
    @Column(name = "nombreCliente", nullable = false, length = 50)
    private String nombreCliente;
    @Basic
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    @Basic
    @Column(name = "telefono", nullable = false, length = 50)
    private String telefono;
    @Basic
    @Column(name = "direccion", nullable = false, length = 50)
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "idVendedor", referencedColumnName = "idVendedor", nullable = false)
    private VendedorEntity vendedorByIdVendedor;
    @OneToOne
    @JoinColumn(name = "idNatural", referencedColumnName = "idNatural")
    private NaturalEntity naturalByIdNatural;
    @OneToOne
    @JoinColumn(name = "idJuridico", referencedColumnName = "idJuridico")
    private JuridicoEntity juridicoByIdJuridico;
    @OneToMany(mappedBy = "clienteByIdCliente")
    private Collection<VentaEntity> comprasByIdCliente;
    @OneToMany(mappedBy = "clienteByIdCliente")
    private Collection<PedidoEntity> pedidosByIdCliente;


    public GetClientResponse toResponse(){
        GetClientResponse response = new  GetClientResponse();
        response.setIdCliente(this.getIdCliente());
        response.setEmail(this.getEmail());
        response.setDireccion(this.getDireccion());
        response.setTelefono(this.getTelefono());
        response.setVendedor(this.getVendedorByIdVendedor().toResponse());
        response.setNombreCliente(this.getNombreCliente());
        if(this.juridicoByIdJuridico != null){
            response.setClienteJuridico(this.juridicoByIdJuridico.toResponse());
        }
        if(this.naturalByIdNatural!=null){
            response.setClienteNatural(this.naturalByIdNatural.toResponse());
        }
        return response;
    }

}
