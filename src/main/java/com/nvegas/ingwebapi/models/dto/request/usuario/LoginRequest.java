package com.nvegas.ingwebapi.models.dto.request.usuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

    public String email;
    public String password;
}
