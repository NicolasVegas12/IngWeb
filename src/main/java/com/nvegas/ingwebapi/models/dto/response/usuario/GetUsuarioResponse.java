package com.nvegas.ingwebapi.models.dto.response.usuario;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;

public class GetUsuarioResponse {

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
