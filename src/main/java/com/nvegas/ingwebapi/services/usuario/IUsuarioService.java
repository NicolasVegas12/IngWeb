package com.nvegas.ingwebapi.services.usuario;


import com.nvegas.ingwebapi.models.entities.UsuariosEntity;

import java.util.List;

public interface IUsuarioService {

    List<UsuariosEntity> getList();
    UsuariosEntity getDetail(Integer id);
    UsuariosEntity saveOrUpdate(UsuariosEntity request);
    Boolean delete(Integer id);

     UsuariosEntity login(String mail, String password);
}
