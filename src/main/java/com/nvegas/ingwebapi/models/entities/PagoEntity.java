package com.nvegas.ingwebapi.models.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "pago", schema = "chikitinesbd", catalog = "")
public class PagoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idPago", nullable = false)
    private int idPago;
    @Basic
    @Column(name = "fecha", nullable = false)
    private Date fecha;
    @Basic
    @Column(name = "monto", nullable = false, precision = 2)
    private double monto;
    @Basic
    @Column(name = "idCdp", nullable = false)
    private int idCdp;
    @Basic
    @Column(name = "idCliente", nullable = false)
    private int idCliente;
    @ManyToOne
    @JoinColumn(name = "idCdp", referencedColumnName = "idCdp", nullable = false)
    private CdpEntity cdpByIdCdp;
    @ManyToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente", nullable = false)
    private ClienteEntity clienteByIdCliente;

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getIdCdp() {
        return idCdp;
    }

    public void setIdCdp(int idCdp) {
        this.idCdp = idCdp;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PagoEntity that = (PagoEntity) o;

        if (idPago != that.idPago) return false;
        if (Double.compare(that.monto, monto) != 0) return false;
        if (idCdp != that.idCdp) return false;
        if (idCliente != that.idCliente) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idPago;
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        temp = Double.doubleToLongBits(monto);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + idCdp;
        result = 31 * result + idCliente;
        return result;
    }

    public CdpEntity getCdpByIdCdp() {
        return cdpByIdCdp;
    }

    public void setCdpByIdCdp(CdpEntity cdpByIdCdp) {
        this.cdpByIdCdp = cdpByIdCdp;
    }

    public ClienteEntity getClienteByIdCliente() {
        return clienteByIdCliente;
    }

    public void setClienteByIdCliente(ClienteEntity clienteByIdCliente) {
        this.clienteByIdCliente = clienteByIdCliente;
    }
}
