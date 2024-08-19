package com.nvegas.ingwebapi.models.dto.response.cliente;

import com.nvegas.ingwebapi.models.dto.response.vendedor.GetVendedorResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetClientResponse {
    private int idCliente;

    private String nombreCliente;

    private String email;

    private String telefono;

    private String direccion;


    private GetVendedorResponse vendedor;

    private GetNaturalClientResponse clienteNatural;

    private GetJuridicClientResponse clienteJuridico;
}
