package com.nvegas.ingwebapi.controllers;

import com.nvegas.ingwebapi.models.dto.request.cliente.SaveClienteJuridicoRequest;
import com.nvegas.ingwebapi.models.dto.request.cliente.SaveClienteNaturalRequest;
import com.nvegas.ingwebapi.models.dto.response.cliente.GetClientResponse;
import com.nvegas.ingwebapi.models.dto.response.error.ErrorMessageResponse;
import com.nvegas.ingwebapi.models.entities.ClienteEntity;
import com.nvegas.ingwebapi.models.entities.JuridicoEntity;
import com.nvegas.ingwebapi.models.entities.NaturalEntity;
import com.nvegas.ingwebapi.models.entities.VendedorEntity;
import com.nvegas.ingwebapi.services.cliente.IClienteService;
import com.nvegas.ingwebapi.services.cliente.juridico.IJuridicoService;
import com.nvegas.ingwebapi.services.cliente.natural.INaturalService;
import com.nvegas.ingwebapi.services.vendedor.IVendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/cliente")
public class ClienteController {
    @Autowired
    IClienteService service;
    @Autowired
    IJuridicoService juridicoService;

    @Autowired
    INaturalService naturalService;

    @Autowired
    IVendedorService vendedorService;

    @GetMapping
    public List<GetClientResponse> getList() {

        List<GetClientResponse> newResponse = new ArrayList<>();
        List<ClienteEntity> response = service.getList();

        for (ClienteEntity newItem : response) {
            newResponse.add(newItem.toResponse());
        }
        return newResponse;
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Object> getDetail(@PathVariable("id") Integer id) {


        ClienteEntity detail = service.getDetail(id);

        if (detail == null) {
            return new ResponseEntity<>(new ErrorMessageResponse(
                    "Not Found",
                    "Not Found",
                    HttpStatus.NOT_FOUND.value(),
                    "Not Found"
            ), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(detail.toResponse(), HttpStatus.OK);
    }

    @PostMapping("/natural")
    public ResponseEntity<Object> createNatural(@RequestBody SaveClienteNaturalRequest request) {

        VendedorEntity vendedor = vendedorService.getDetail(request.getIdVendedor());

        if (vendedor == null) {
            return new ResponseEntity<>(new ErrorMessageResponse(
                    "Not Found",
                    "Not Found",
                    HttpStatus.NOT_FOUND.value(),
                    "Not Found"
            ), HttpStatus.NOT_FOUND);
        }

        NaturalEntity savedNatural = naturalService.saveOrUpdate(request.toNaturalEntity());

        ClienteEntity clienteEntity = request.toEntity();

        clienteEntity.setNaturalByIdNatural(savedNatural);
        clienteEntity.setVendedorByIdVendedor(vendedor);

        ClienteEntity saved = service.saveOrUpdate(clienteEntity);

        return new ResponseEntity<>(saved.toResponse(), HttpStatus.CREATED);
    }

    @PostMapping("/juridico")
    public ResponseEntity<Object> createJuridico(@RequestBody SaveClienteJuridicoRequest request) {
        VendedorEntity vendedor = vendedorService.getDetail(request.getIdVendedor());

        if (vendedor == null) {
            return new ResponseEntity<>(new ErrorMessageResponse(
                    "Not Found",
                    "Not Found",
                    HttpStatus.NOT_FOUND.value(),
                    "Not Found"
            ), HttpStatus.NOT_FOUND);
        }

        JuridicoEntity savedNatural = juridicoService.saveOrUpdate(request.toJuridicoEntity());

        ClienteEntity clienteEntity = request.toEntity();

        clienteEntity.setJuridicoByIdJuridico(savedNatural);

        clienteEntity.setVendedorByIdVendedor(vendedor);

        ClienteEntity saved = service.saveOrUpdate(clienteEntity);

        return new ResponseEntity<>(saved.toResponse(), HttpStatus.CREATED);
    }


    /*@PutMapping
    public ResponseEntity<Object> update(@RequestBody UpdateJefeCompraRequest request) {

        JefeComprasEntity detail = service.getDetail(request.getIdJefeCompras());

        if (detail == null) {
            return new ResponseEntity<>(new ErrorMessageResponse(
                    "Not Found",
                    "Not Found",
                    HttpStatus.NOT_FOUND.value(),
                    "Not Found"
            ), HttpStatus.NOT_FOUND);
        }

        JefeComprasEntity updatedProduct = service.saveOrUpdate(detail.update(request));

        return new ResponseEntity<>(updatedProduct.toResponse(), HttpStatus.OK);

    }*/

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
        Boolean deleted = service.delete(id);
        if (Boolean.FALSE.equals(deleted)) {
            return new ResponseEntity<>(
                    new ErrorMessageResponse(
                            "Not Found",
                            "Not Found",
                            HttpStatus.NOT_FOUND.value(),
                            "Not Found"
                    ), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
