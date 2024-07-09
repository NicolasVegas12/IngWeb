package com.nvegas.ingwebapi.models.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "cliente", schema = "chikitinesbd", catalog = "")
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
    @Basic
    @Column(name = "idVendedor", nullable = false)
    private int idVendedor;
    @Basic
    @Column(name = "idNatural", nullable = true)
    private Integer idNatural;
    @Basic
    @Column(name = "idJuridico", nullable = true)
    private Integer idJuridico;
    @ManyToOne
    @JoinColumn(name = "idVendedor", referencedColumnName = "idVendedor", nullable = false)
    private VendedorEntity vendedorByIdVendedor;
    @ManyToOne
    @JoinColumn(name = "idNatural", referencedColumnName = "idNatural")
    private NaturalEntity naturalByIdNatural;
    @ManyToOne
    @JoinColumn(name = "idJuridico", referencedColumnName = "idJuridico")
    private JuridicoEntity juridicoByIdJuridico;
    @OneToMany(mappedBy = "clienteByIdCliente")
    private Collection<PagoEntity> pagosByIdCliente;
    @OneToMany(mappedBy = "clienteByIdCliente")
    private Collection<PedidoEntity> pedidosByIdCliente;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
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

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public Integer getIdNatural() {
        return idNatural;
    }

    public void setIdNatural(Integer idNatural) {
        this.idNatural = idNatural;
    }

    public Integer getIdJuridico() {
        return idJuridico;
    }

    public void setIdJuridico(Integer idJuridico) {
        this.idJuridico = idJuridico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClienteEntity that = (ClienteEntity) o;

        if (idCliente != that.idCliente) return false;
        if (idVendedor != that.idVendedor) return false;
        if (nombreCliente != null ? !nombreCliente.equals(that.nombreCliente) : that.nombreCliente != null)
            return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (telefono != null ? !telefono.equals(that.telefono) : that.telefono != null) return false;
        if (direccion != null ? !direccion.equals(that.direccion) : that.direccion != null) return false;
        if (idNatural != null ? !idNatural.equals(that.idNatural) : that.idNatural != null) return false;
        if (idJuridico != null ? !idJuridico.equals(that.idJuridico) : that.idJuridico != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCliente;
        result = 31 * result + (nombreCliente != null ? nombreCliente.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (telefono != null ? telefono.hashCode() : 0);
        result = 31 * result + (direccion != null ? direccion.hashCode() : 0);
        result = 31 * result + idVendedor;
        result = 31 * result + (idNatural != null ? idNatural.hashCode() : 0);
        result = 31 * result + (idJuridico != null ? idJuridico.hashCode() : 0);
        return result;
    }

    public VendedorEntity getVendedorByIdVendedor() {
        return vendedorByIdVendedor;
    }

    public void setVendedorByIdVendedor(VendedorEntity vendedorByIdVendedor) {
        this.vendedorByIdVendedor = vendedorByIdVendedor;
    }

    public NaturalEntity getNaturalByIdNatural() {
        return naturalByIdNatural;
    }

    public void setNaturalByIdNatural(NaturalEntity naturalByIdNatural) {
        this.naturalByIdNatural = naturalByIdNatural;
    }

    public JuridicoEntity getJuridicoByIdJuridico() {
        return juridicoByIdJuridico;
    }

    public void setJuridicoByIdJuridico(JuridicoEntity juridicoByIdJuridico) {
        this.juridicoByIdJuridico = juridicoByIdJuridico;
    }

    public Collection<PagoEntity> getPagosByIdCliente() {
        return pagosByIdCliente;
    }

    public void setPagosByIdCliente(Collection<PagoEntity> pagosByIdCliente) {
        this.pagosByIdCliente = pagosByIdCliente;
    }

    public Collection<PedidoEntity> getPedidosByIdCliente() {
        return pedidosByIdCliente;
    }

    public void setPedidosByIdCliente(Collection<PedidoEntity> pedidosByIdCliente) {
        this.pedidosByIdCliente = pedidosByIdCliente;
    }
}
