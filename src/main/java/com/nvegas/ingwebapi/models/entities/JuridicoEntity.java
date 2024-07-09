package com.nvegas.ingwebapi.models.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "juridico", schema = "chikitinesbd", catalog = "")
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
    @OneToMany(mappedBy = "juridicoByIdJuridico")
    private Collection<ClienteEntity> clientesByIdJuridico;

    public int getIdJuridico() {
        return idJuridico;
    }

    public void setIdJuridico(int idJuridico) {
        this.idJuridico = idJuridico;
    }

    public String getDniRepre() {
        return dniRepre;
    }

    public void setDniRepre(String dniRepre) {
        this.dniRepre = dniRepre;
    }

    public String getNombreRepre() {
        return nombreRepre;
    }

    public void setNombreRepre(String nombreRepre) {
        this.nombreRepre = nombreRepre;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JuridicoEntity that = (JuridicoEntity) o;

        if (idJuridico != that.idJuridico) return false;
        if (dniRepre != null ? !dniRepre.equals(that.dniRepre) : that.dniRepre != null) return false;
        if (nombreRepre != null ? !nombreRepre.equals(that.nombreRepre) : that.nombreRepre != null) return false;
        if (ruc != null ? !ruc.equals(that.ruc) : that.ruc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idJuridico;
        result = 31 * result + (dniRepre != null ? dniRepre.hashCode() : 0);
        result = 31 * result + (nombreRepre != null ? nombreRepre.hashCode() : 0);
        result = 31 * result + (ruc != null ? ruc.hashCode() : 0);
        return result;
    }

    public Collection<ClienteEntity> getClientesByIdJuridico() {
        return clientesByIdJuridico;
    }

    public void setClientesByIdJuridico(Collection<ClienteEntity> clientesByIdJuridico) {
        this.clientesByIdJuridico = clientesByIdJuridico;
    }
}
