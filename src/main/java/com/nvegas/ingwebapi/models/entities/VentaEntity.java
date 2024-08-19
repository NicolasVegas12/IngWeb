package com.nvegas.ingwebapi.models.entities;

import com.nvegas.ingwebapi.models.dto.response.venta.GetVentaResponse;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(name = "venta", schema = "chikitinesbd")
public class VentaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idVenta", nullable = false)
    private int idVenta;
    @Basic
    @Column(name = "nroVenta", nullable = false, length = 50)
    private String nroVenta;
    @Basic
    @Column(name = "fecha", nullable = false, length = 50)
    private Date fecha;
    @Basic
    @Column(name = "estado", nullable = false)
    private Boolean estado;
    @OneToOne
    @JoinColumn(name = "idCdp", referencedColumnName = "idCdp")
    private CdpEntity cdpByIdCdp;
    @OneToMany(mappedBy = "ventaByIdVenta")
    private Collection<DetalleVentaEntity> detalleVentasByIdVenta;

    @ManyToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente", nullable = false)
    private ClienteEntity clienteByIdCliente;

    @ManyToOne
    @JoinColumn(name = "idVendedor", referencedColumnName = "idVendedor", nullable = false)
    private VendedorEntity vendedorByIdVendedor;


    public GetVentaResponse toResponse() {
        GetVentaResponse response = new GetVentaResponse();

        response.setIdVenta(this.getIdVenta());
        response.setNroVenta(this.getNroVenta());
        response.setFecha(this.getFecha());
        if(this.getCdpByIdCdp() !=null){
            response.setIdCdp(this.getCdpByIdCdp().getIdCdp());
        }
        response.setDetalleVenta(
                this.detalleVentasByIdVenta.stream().map(DetalleVentaEntity::toResponse).collect(Collectors.toList())
        );
        response.setIdCliente(this.getClienteByIdCliente().getIdCliente());
        response.setIdVendedor(this.getVendedorByIdVendedor().getIdVendedor());
        return response;

    }

}
