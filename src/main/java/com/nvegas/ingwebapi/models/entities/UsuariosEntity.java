package com.nvegas.ingwebapi.models.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios", schema = "chikitinesbd", catalog = "")
public class UsuariosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idUsuario", nullable = false)
    private int idUsuario;
    @Basic
    @Column(name = "nombreUsuario", nullable = false, length = 50)
    private String nombreUsuario;
    @Basic
    @Column(name = "correo", nullable = false, length = 50)
    private String correo;
    @Basic
    @Column(name = "contrasena", nullable = false, length = 50)
    private String contrasena;
    @Basic
    @Column(name = "idJefeAlmacen", nullable = true)
    private Integer idJefeAlmacen;
    @Basic
    @Column(name = "idJefeCompras", nullable = true)
    private Integer idJefeCompras;
    @Basic
    @Column(name = "idVendedor", nullable = true)
    private Integer idVendedor;
    @ManyToOne
    @JoinColumn(name = "idJefeAlmacen", referencedColumnName = "idJefeAlmacen")
    private JefeAlmacenEntity jefeAlmacenByIdJefeAlmacen;
    @ManyToOne
    @JoinColumn(name = "idJefeCompras", referencedColumnName = "idJefeCompras")
    private JefeComprasEntity jefeComprasByIdJefeCompras;
    @ManyToOne
    @JoinColumn(name = "idVendedor", referencedColumnName = "idVendedor")
    private VendedorEntity vendedorByIdVendedor;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Integer getIdJefeAlmacen() {
        return idJefeAlmacen;
    }

    public void setIdJefeAlmacen(Integer idJefeAlmacen) {
        this.idJefeAlmacen = idJefeAlmacen;
    }

    public Integer getIdJefeCompras() {
        return idJefeCompras;
    }

    public void setIdJefeCompras(Integer idJefeCompras) {
        this.idJefeCompras = idJefeCompras;
    }

    public Integer getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Integer idVendedor) {
        this.idVendedor = idVendedor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsuariosEntity that = (UsuariosEntity) o;

        if (idUsuario != that.idUsuario) return false;
        if (nombreUsuario != null ? !nombreUsuario.equals(that.nombreUsuario) : that.nombreUsuario != null)
            return false;
        if (correo != null ? !correo.equals(that.correo) : that.correo != null) return false;
        if (contrasena != null ? !contrasena.equals(that.contrasena) : that.contrasena != null) return false;
        if (idJefeAlmacen != null ? !idJefeAlmacen.equals(that.idJefeAlmacen) : that.idJefeAlmacen != null)
            return false;
        if (idJefeCompras != null ? !idJefeCompras.equals(that.idJefeCompras) : that.idJefeCompras != null)
            return false;
        if (idVendedor != null ? !idVendedor.equals(that.idVendedor) : that.idVendedor != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUsuario;
        result = 31 * result + (nombreUsuario != null ? nombreUsuario.hashCode() : 0);
        result = 31 * result + (correo != null ? correo.hashCode() : 0);
        result = 31 * result + (contrasena != null ? contrasena.hashCode() : 0);
        result = 31 * result + (idJefeAlmacen != null ? idJefeAlmacen.hashCode() : 0);
        result = 31 * result + (idJefeCompras != null ? idJefeCompras.hashCode() : 0);
        result = 31 * result + (idVendedor != null ? idVendedor.hashCode() : 0);
        return result;
    }

    public JefeAlmacenEntity getJefeAlmacenByIdJefeAlmacen() {
        return jefeAlmacenByIdJefeAlmacen;
    }

    public void setJefeAlmacenByIdJefeAlmacen(JefeAlmacenEntity jefeAlmacenByIdJefeAlmacen) {
        this.jefeAlmacenByIdJefeAlmacen = jefeAlmacenByIdJefeAlmacen;
    }

    public JefeComprasEntity getJefeComprasByIdJefeCompras() {
        return jefeComprasByIdJefeCompras;
    }

    public void setJefeComprasByIdJefeCompras(JefeComprasEntity jefeComprasByIdJefeCompras) {
        this.jefeComprasByIdJefeCompras = jefeComprasByIdJefeCompras;
    }

    public VendedorEntity getVendedorByIdVendedor() {
        return vendedorByIdVendedor;
    }

    public void setVendedorByIdVendedor(VendedorEntity vendedorByIdVendedor) {
        this.vendedorByIdVendedor = vendedorByIdVendedor;
    }
}
