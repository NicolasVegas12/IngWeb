package com.nvegas.ingwebapi.models.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "naturalClient", schema = "chikitinesbd", catalog = "")
public class NaturalEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idNatural", nullable = false)
    private int idNatural;
    @Basic
    @Column(name = "dni", nullable = false, length = 50)
    private String dni;
    @OneToMany(mappedBy = "naturalByIdNatural")
    private Collection<ClienteEntity> clientesByIdNatural;

    public int getIdNatural() {
        return idNatural;
    }

    public void setIdNatural(int idNatural) {
        this.idNatural = idNatural;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NaturalEntity that = (NaturalEntity) o;

        if (idNatural != that.idNatural) return false;
        if (dni != null ? !dni.equals(that.dni) : that.dni != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idNatural;
        result = 31 * result + (dni != null ? dni.hashCode() : 0);
        return result;
    }

    public Collection<ClienteEntity> getClientesByIdNatural() {
        return clientesByIdNatural;
    }

    public void setClientesByIdNatural(Collection<ClienteEntity> clientesByIdNatural) {
        this.clientesByIdNatural = clientesByIdNatural;
    }
}
