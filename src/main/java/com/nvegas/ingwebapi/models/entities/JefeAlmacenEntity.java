package com.nvegas.ingwebapi.models.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "jefe_almacen", schema = "chikitinesbd", catalog = "")
public class JefeAlmacenEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idJefeAlmacen", nullable = false)
    private int idJefeAlmacen;
    @Basic
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Basic
    @Column(name = "genero", nullable = false, length = 50)
    private String genero;
    @Basic
    @Column(name = "telefono", nullable = false, length = 50)
    private String telefono;
    @Basic
    @Column(name = "direccion", nullable = false, length = 50)
    private String direccion;
    @OneToMany(mappedBy = "jefeAlmacenByIdJefeAlmacen")
    private Collection<NotaIngresoEntity> notaIngresosByIdJefeAlmacen;
    @OneToMany(mappedBy = "jefeAlmacenByIdJefeAlmacen")
    private Collection<NotaSalidaEntity> notaSalidasByIdJefeAlmacen;
    @OneToMany(mappedBy = "jefeAlmacenByIdJefeAlmacen")
    private Collection<RequerimientoEntity> requerimientosByIdJefeAlmacen;
    @OneToMany(mappedBy = "jefeAlmacenByIdJefeAlmacen")
    private Collection<UsuariosEntity> usuariosByIdJefeAlmacen;

    public int getIdJefeAlmacen() {
        return idJefeAlmacen;
    }

    public void setIdJefeAlmacen(int idJefeAlmacen) {
        this.idJefeAlmacen = idJefeAlmacen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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

        JefeAlmacenEntity that = (JefeAlmacenEntity) o;

        if (idJefeAlmacen != that.idJefeAlmacen) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (genero != null ? !genero.equals(that.genero) : that.genero != null) return false;
        if (telefono != null ? !telefono.equals(that.telefono) : that.telefono != null) return false;
        if (direccion != null ? !direccion.equals(that.direccion) : that.direccion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idJefeAlmacen;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (genero != null ? genero.hashCode() : 0);
        result = 31 * result + (telefono != null ? telefono.hashCode() : 0);
        result = 31 * result + (direccion != null ? direccion.hashCode() : 0);
        return result;
    }

    public Collection<NotaIngresoEntity> getNotaIngresosByIdJefeAlmacen() {
        return notaIngresosByIdJefeAlmacen;
    }

    public void setNotaIngresosByIdJefeAlmacen(Collection<NotaIngresoEntity> notaIngresosByIdJefeAlmacen) {
        this.notaIngresosByIdJefeAlmacen = notaIngresosByIdJefeAlmacen;
    }

    public Collection<NotaSalidaEntity> getNotaSalidasByIdJefeAlmacen() {
        return notaSalidasByIdJefeAlmacen;
    }

    public void setNotaSalidasByIdJefeAlmacen(Collection<NotaSalidaEntity> notaSalidasByIdJefeAlmacen) {
        this.notaSalidasByIdJefeAlmacen = notaSalidasByIdJefeAlmacen;
    }

    public Collection<RequerimientoEntity> getRequerimientosByIdJefeAlmacen() {
        return requerimientosByIdJefeAlmacen;
    }

    public void setRequerimientosByIdJefeAlmacen(Collection<RequerimientoEntity> requerimientosByIdJefeAlmacen) {
        this.requerimientosByIdJefeAlmacen = requerimientosByIdJefeAlmacen;
    }

    public Collection<UsuariosEntity> getUsuariosByIdJefeAlmacen() {
        return usuariosByIdJefeAlmacen;
    }

    public void setUsuariosByIdJefeAlmacen(Collection<UsuariosEntity> usuariosByIdJefeAlmacen) {
        this.usuariosByIdJefeAlmacen = usuariosByIdJefeAlmacen;
    }
}
