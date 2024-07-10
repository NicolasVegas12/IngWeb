package com.nvegas.ingwebapi.models.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "pedido", schema = "chikitinesbd", catalog = "")
public class PedidoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idPedido", nullable = false)
    private int idPedido;
    @Basic
    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @OneToMany(mappedBy = "pedidoByPedidoIdPedido")
    private Collection<DetallePedidoEntity> detallePedidosByIdPedido;
    @ManyToOne
    @JoinColumn(name = "idProveedor", referencedColumnName = "idProveedor", nullable = false)
    private ProveedorEntity proveedorByIdProveedor;
    @ManyToOne
    @JoinColumn(name = "idVendedor", referencedColumnName = "idVendedor", nullable = false)
    private VendedorEntity vendedorByIdVendedor;
    @ManyToOne
    @JoinColumn(name = "idJefeCompras", referencedColumnName = "idJefeCompras", nullable = false)
    private JefeComprasEntity jefeComprasByIdJefeCompras;
    @ManyToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente", nullable = false)
    private ClienteEntity clienteByIdCliente;

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PedidoEntity that = (PedidoEntity) o;

        if (idPedido != that.idPedido) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPedido;
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        return result;
    }

    public Collection<DetallePedidoEntity> getDetallePedidosByIdPedido() {
        return detallePedidosByIdPedido;
    }

    public void setDetallePedidosByIdPedido(Collection<DetallePedidoEntity> detallePedidosByIdPedido) {
        this.detallePedidosByIdPedido = detallePedidosByIdPedido;
    }

    public ProveedorEntity getProveedorByIdProveedor() {
        return proveedorByIdProveedor;
    }

    public void setProveedorByIdProveedor(ProveedorEntity proveedorByIdProveedor) {
        this.proveedorByIdProveedor = proveedorByIdProveedor;
    }

    public VendedorEntity getVendedorByIdVendedor() {
        return vendedorByIdVendedor;
    }

    public void setVendedorByIdVendedor(VendedorEntity vendedorByIdVendedor) {
        this.vendedorByIdVendedor = vendedorByIdVendedor;
    }

    public JefeComprasEntity getJefeComprasByIdJefeCompras() {
        return jefeComprasByIdJefeCompras;
    }

    public void setJefeComprasByIdJefeCompras(JefeComprasEntity jefeComprasByIdJefeCompras) {
        this.jefeComprasByIdJefeCompras = jefeComprasByIdJefeCompras;
    }

    public ClienteEntity getClienteByIdCliente() {
        return clienteByIdCliente;
    }

    public void setClienteByIdCliente(ClienteEntity clienteByIdCliente) {
        this.clienteByIdCliente = clienteByIdCliente;
    }
}
