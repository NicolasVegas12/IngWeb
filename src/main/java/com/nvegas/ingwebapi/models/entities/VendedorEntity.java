package com.nvegas.ingwebapi.models.entities;

import com.nvegas.ingwebapi.models.dto.request.proveedor.UpdateProveedorRequest;
import com.nvegas.ingwebapi.models.dto.request.vendedor.UpdateVendedorRequest;
import com.nvegas.ingwebapi.models.dto.response.proveedor.GetProveedorResponse;
import com.nvegas.ingwebapi.models.dto.response.vendedor.GetVendedorRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@Entity
@Table(name = "vendedor", schema = "chikitinesbd")
public class VendedorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idVendedor", nullable = false)
    private int idVendedor;
    @Basic
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Basic
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    @Basic
    @Column(name = "telefono", nullable = false, length = 50)
    private String telefono;
    @Basic
    @Column(name = "direccion", nullable = false, length = 50)
    private String direccion;
    @OneToMany(mappedBy = "vendedorByIdVendedor")
    private Collection<ClienteEntity> clientesByIdVendedor;
    @OneToMany(mappedBy = "vendedorByIdVendedor")
    private Collection<PedidoEntity> pedidosByIdVendedor;
    @OneToMany(mappedBy = "vendedorByIdVendedor")
    private Collection<UsuariosEntity> usuariosByIdVendedor;

    @OneToMany(mappedBy = "vendedorByIdVendedor")
    private Collection<VentaEntity> ventasByIdVendedor;


    public VendedorEntity update(UpdateVendedorRequest request){
        setNombre(request.getNombre());
        setDireccion(request.getDireccion());
        setEmail(request.getEmail());
        setTelefono(request.getTelefono());
        return this;
    }

    public GetVendedorRequest toResponse(){
        GetVendedorRequest response = new GetVendedorRequest();
        response.setNombre(this.nombre);
        response.setDireccion(this.direccion);
        response.setEmail(this.email);
        response.setTelefono(this.telefono);
        response.setIdVendedor(this.idVendedor);

        return response;
    }
}
