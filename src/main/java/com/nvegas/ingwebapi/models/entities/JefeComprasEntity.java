package com.nvegas.ingwebapi.models.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "jefe_compras", schema = "chikitinesbd", catalog = "")
public class JefeComprasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idJefeCompras", nullable = false)
    private int idJefeCompras;
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
    @Basic
    @Column(name = "direccion", nullable = false, length = 50)
    private String direccion;
    @OneToMany(mappedBy = "jefeComprasByIdJefeCompras")
    private Collection<PedidoEntity> pedidosByIdJefeCompras;
    @OneToMany(mappedBy = "jefeComprasByIdJefeCompras")
    private Collection<ProveedorEntity> proveedorsByIdJefeCompras;
    @OneToMany(mappedBy = "jefeComprasByIdJefeCompras")
    private Collection<RequerimientoEntity> requerimientosByIdJefeCompras;
    @OneToMany(mappedBy = "jefeComprasByIdJefeCompras")
    private Collection<UsuariosEntity> usuariosByIdJefeCompras;

    public int getIdJefeCompras() {
        return idJefeCompras;
    }

    public void setIdJefeCompras(int idJefeCompras) {
        this.idJefeCompras = idJefeCompras;
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

        JefeComprasEntity that = (JefeComprasEntity) o;

        if (idJefeCompras != that.idJefeCompras) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (dni != null ? !dni.equals(that.dni) : that.dni != null) return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;
        if (telefono != null ? !telefono.equals(that.telefono) : that.telefono != null) return false;
        if (direccion != null ? !direccion.equals(that.direccion) : that.direccion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idJefeCompras;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (dni != null ? dni.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (telefono != null ? telefono.hashCode() : 0);
        result = 31 * result + (direccion != null ? direccion.hashCode() : 0);
        return result;
    }

    public Collection<PedidoEntity> getPedidosByIdJefeCompras() {
        return pedidosByIdJefeCompras;
    }

    public void setPedidosByIdJefeCompras(Collection<PedidoEntity> pedidosByIdJefeCompras) {
        this.pedidosByIdJefeCompras = pedidosByIdJefeCompras;
    }

    public Collection<ProveedorEntity> getProveedorsByIdJefeCompras() {
        return proveedorsByIdJefeCompras;
    }

    public void setProveedorsByIdJefeCompras(Collection<ProveedorEntity> proveedorsByIdJefeCompras) {
        this.proveedorsByIdJefeCompras = proveedorsByIdJefeCompras;
    }

    public Collection<RequerimientoEntity> getRequerimientosByIdJefeCompras() {
        return requerimientosByIdJefeCompras;
    }

    public void setRequerimientosByIdJefeCompras(Collection<RequerimientoEntity> requerimientosByIdJefeCompras) {
        this.requerimientosByIdJefeCompras = requerimientosByIdJefeCompras;
    }

    public Collection<UsuariosEntity> getUsuariosByIdJefeCompras() {
        return usuariosByIdJefeCompras;
    }

    public void setUsuariosByIdJefeCompras(Collection<UsuariosEntity> usuariosByIdJefeCompras) {
        this.usuariosByIdJefeCompras = usuariosByIdJefeCompras;
    }
}
