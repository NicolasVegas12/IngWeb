package com.nvegas.ingwebapi.controllers;


import com.nvegas.ingwebapi.models.dto.request.jefeCompra.SaveJefeCompraRequest;
import com.nvegas.ingwebapi.models.dto.request.jefeCompra.UpdateJefeCompraRequest;
import com.nvegas.ingwebapi.models.dto.request.vendedor.SaveVendedorRequest;
import com.nvegas.ingwebapi.models.dto.request.vendedor.UpdateVendedorRequest;
import com.nvegas.ingwebapi.models.dto.response.error.ErrorMessageResponse;
import com.nvegas.ingwebapi.models.dto.response.jefeCompra.GetJefeCompraResponse;
import com.nvegas.ingwebapi.models.dto.response.vendedor.GetVendedorRequest;
import com.nvegas.ingwebapi.models.entities.JefeComprasEntity;
import com.nvegas.ingwebapi.models.entities.VendedorEntity;
import com.nvegas.ingwebapi.services.jefeCompras.IJefeComprasService;
import com.nvegas.ingwebapi.services.vendedor.IVendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/jefe_compra")
public class JefeCompraController {
    @Autowired
    IJefeComprasService service;

    @GetMapping
    public List<GetJefeCompraResponse> getList() {

        List<GetJefeCompraResponse> newResponse = new ArrayList<>();
        List<JefeComprasEntity> response = service.getList();

        for (JefeComprasEntity newItem : response) {
            newResponse.add(newItem.toResponse());
        }
        return newResponse;
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Object> getDetail(@PathVariable("id") Integer id) {


        JefeComprasEntity detail = service.getDetail(id);

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

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody SaveJefeCompraRequest request) {
        JefeComprasEntity saved = service.saveOrUpdate(request.toEntity());

        return new ResponseEntity<>(saved.toResponse(), HttpStatus.CREATED);
    }

    @PutMapping
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

    }

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
