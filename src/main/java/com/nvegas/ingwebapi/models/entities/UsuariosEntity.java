package com.nvegas.ingwebapi.models.entities;

import com.nvegas.ingwebapi.models.dto.request.usuario.UpdateUsuarioRequest;
import com.nvegas.ingwebapi.models.dto.response.usuario.GetUsuarioResponse;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuarios", schema = "chikitinesbd")
public class UsuariosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idUsuario", nullable = false)
    @Getter
    @Setter
    private int idUsuario;
    @Basic
    @Column(name = "nombreUsuario", nullable = false, length = 50)
    @Getter
    @Setter
    private String nombreUsuario;
    @Basic
    @Column(name = "correo", nullable = false, length = 50)
    @Getter
    @Setter
    private String correo;
    @Basic
    @Column(name = "contrasena", nullable = false, length = 50)
    @Getter
    @Setter
    private String contrasena;


    @ManyToOne
    @JoinColumn(name = "idJefeAlmacen", referencedColumnName = "idJefeAlmacen")
    @Getter
    @Setter
    private JefeAlmacenEntity jefeAlmacenByIdJefeAlmacen;
    @ManyToOne
    @JoinColumn(name = "idJefeCompras", referencedColumnName = "idJefeCompras")
    @Getter
    @Setter
    private JefeComprasEntity jefeComprasByIdJefeCompras;
    @ManyToOne
    @JoinColumn(name = "idVendedor", referencedColumnName = "idVendedor")
    @Getter
    @Setter
    private VendedorEntity vendedorByIdVendedor;

    public UsuariosEntity toUpdate(UpdateUsuarioRequest request) {
        setCorreo(request.getCorreo());
        setNombreUsuario(request.getNombreUsuario());
        setContrasena(request.getContrasena());
        return this;
    }

    public GetUsuarioResponse toResponse() {
        GetUsuarioResponse response = new GetUsuarioResponse();
        response.setIdUsuario(this.idUsuario);
        response.setCorreo(this.correo);
        response.setContrasena(this.contrasena);
        response.setNombreUsuario(this.nombreUsuario);
        if (this.jefeComprasByIdJefeCompras != null) {
            response.setIdJefeCompras(this.jefeComprasByIdJefeCompras.getIdJefeCompras());
        }
        if(this.jefeAlmacenByIdJefeAlmacen!=null){
            response.setIdJefeAlmacen(this.jefeAlmacenByIdJefeAlmacen.getIdJefeAlmacen());
        }
        if(this.vendedorByIdVendedor !=null){
            response.setIdVendedor(this.vendedorByIdVendedor.getIdVendedor());
        }
        return response;
    }


}
