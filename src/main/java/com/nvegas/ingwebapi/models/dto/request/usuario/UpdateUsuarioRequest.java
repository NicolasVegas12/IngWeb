package com.nvegas.ingwebapi.models.dto.request.usuario;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;

public class UpdateUsuarioRequest {

    public UpdateUsuarioRequest(int idUsuario, String nombreUsuario, String correo, String contrasena, Integer idJefeAlmacen, Integer idJefeCompras, Integer idVendedor) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.contrasena = contrasena;
        this.idJefeAlmacen = idJefeAlmacen;
        this.idJefeCompras = idJefeCompras;
        this.idVendedor = idVendedor;
    }

    @Getter
    @Setter
    private int idUsuario;

    @Getter
    @Setter
    private String nombreUsuario;

    @Getter
    @Setter
    private String correo;

    @Getter
    @Setter
    private String contrasena;

    @Getter
    @Setter
    @Nullable
    private Integer idJefeAlmacen;
    @Getter
    @Setter
    @Nullable
    private Integer idJefeCompras;
    @Getter
    @Setter
    @Nullable
    private Integer idVendedor;
}
