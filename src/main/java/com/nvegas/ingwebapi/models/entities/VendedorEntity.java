package com.nvegas.ingwebapi.models.entities;

import com.nvegas.ingwebapi.models.dto.request.proveedor.UpdateProveedorRequest;
import com.nvegas.ingwebapi.models.dto.request.vendedor.UpdateVendedorRequest;
import com.nvegas.ingwebapi.models.dto.response.proveedor.GetProveedorResponse;
import com.nvegas.ingwebapi.models.dto.response.vendedor.GetVendedorRequest;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "vendedor", schema = "chikitinesbd", catalog = "")
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

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VendedorEntity that = (VendedorEntity) o;

        if (idVendedor != that.idVendedor) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (telefono != null ? !telefono.equals(that.telefono) : that.telefono != null) return false;
        if (direccion != null ? !direccion.equals(that.direccion) : that.direccion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idVendedor;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (telefono != null ? telefono.hashCode() : 0);
        result = 31 * result + (direccion != null ? direccion.hashCode() : 0);
        return result;
    }

    public Collection<ClienteEntity> getClientesByIdVendedor() {
        return clientesByIdVendedor;
    }

    public void setClientesByIdVendedor(Collection<ClienteEntity> clientesByIdVendedor) {
        this.clientesByIdVendedor = clientesByIdVendedor;
    }

    public Collection<PedidoEntity> getPedidosByIdVendedor() {
        return pedidosByIdVendedor;
    }

    public void setPedidosByIdVendedor(Collection<PedidoEntity> pedidosByIdVendedor) {
        this.pedidosByIdVendedor = pedidosByIdVendedor;
    }

    public Collection<UsuariosEntity> getUsuariosByIdVendedor() {
        return usuariosByIdVendedor;
    }

    public void setUsuariosByIdVendedor(Collection<UsuariosEntity> usuariosByIdVendedor) {
        this.usuariosByIdVendedor = usuariosByIdVendedor;
    }

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
