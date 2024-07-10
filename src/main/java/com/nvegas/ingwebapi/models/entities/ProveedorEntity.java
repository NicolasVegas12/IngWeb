package com.nvegas.ingwebapi.models.entities;

import com.nvegas.ingwebapi.models.dto.request.product.UpdateProductRequest;
import com.nvegas.ingwebapi.models.dto.request.proveedor.UpdateProveedorRequest;
import com.nvegas.ingwebapi.models.dto.response.product.GetProductResponse;
import com.nvegas.ingwebapi.models.dto.response.proveedor.GetProveedorResponse;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "proveedor", schema = "chikitinesbd", catalog = "")
public class ProveedorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idProveedor", nullable = false)
    private int idProveedor;
    @Basic
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Basic
    @Column(name = "dni", nullable = false, length = 50)
    private String dni;
    @Basic
    @Column(name = "estado", nullable = false, length = 50)
    private String estado;
    @Basic
    @Column(name = "telefono", nullable = false, length = 50)
    private String telefono;

    @OneToMany(mappedBy = "proveedorByIdProveedor")
    private Collection<PedidoEntity> pedidosByIdProveedor;
    @ManyToOne
    @JoinColumn(name = "idJefeCompras", referencedColumnName = "idJefeCompras", nullable = false)
    private JefeComprasEntity jefeComprasByIdJefeCompras;

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProveedorEntity that = (ProveedorEntity) o;

        if (idProveedor != that.idProveedor) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (dni != null ? !dni.equals(that.dni) : that.dni != null) return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;
        if (telefono != null ? !telefono.equals(that.telefono) : that.telefono != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProveedor;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (dni != null ? dni.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (telefono != null ? telefono.hashCode() : 0);
        return result;
    }

    public Collection<PedidoEntity> getPedidosByIdProveedor() {
        return pedidosByIdProveedor;
    }

    public void setPedidosByIdProveedor(Collection<PedidoEntity> pedidosByIdProveedor) {
        this.pedidosByIdProveedor = pedidosByIdProveedor;
    }

    public JefeComprasEntity getJefeComprasByIdJefeCompras() {
        return jefeComprasByIdJefeCompras;
    }

    public void setJefeComprasByIdJefeCompras(JefeComprasEntity jefeComprasByIdJefeCompras) {
        this.jefeComprasByIdJefeCompras = jefeComprasByIdJefeCompras;
    }

    public ProveedorEntity update(UpdateProveedorRequest request){
        setNombre(request.getNombre());
        setDni(request.getDni());
        setTelefono(request.getTelefono());
        return this;
    }

    public GetProveedorResponse toResponse(){
        GetProveedorResponse response = new GetProveedorResponse();
        response.setNombre(this.nombre);
        response.setDni(this.dni);
        response.setTelefono(this.telefono);
        response.setIdProveedor(this.idProveedor);

        return response;
    }
}
