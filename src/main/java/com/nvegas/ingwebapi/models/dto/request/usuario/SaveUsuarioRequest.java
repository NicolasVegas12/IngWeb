package com.nvegas.ingwebapi.models.dto.request.usuario;

import com.nvegas.ingwebapi.models.entities.ProveedorEntity;
import com.nvegas.ingwebapi.models.entities.UsuariosEntity;
import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;

public class SaveUsuarioRequest {

    public SaveUsuarioRequest(String nombreUsuario, String correo, String contrasena, Integer idJefeAlmacen, Integer idJefeCompras, Integer idVendedor) {
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.contrasena = contrasena;
        this.idJefeAlmacen = idJefeAlmacen;
        this.idJefeCompras = idJefeCompras;
        this.idVendedor = idVendedor;
    }

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


    public UsuariosEntity toEntity() {
        UsuariosEntity request = new UsuariosEntity();
        request.setCorreo(this.getCorreo());
        request.setContrasena(this.getContrasena());
        request.setNombreUsuario(this.getCorreo());
        return request;
    }


}
