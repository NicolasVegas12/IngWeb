package com.nvegas.ingwebapi.repository;

import com.nvegas.ingwebapi.models.entities.UsuariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository  extends JpaRepository<UsuariosEntity, Integer> {
    UsuariosEntity getUsuariosEntitiesByCorreoAndContrasena(String correo,String contrasena);
}
