package com.nvegas.ingwebapi.controllers;

import com.nvegas.ingwebapi.models.dto.request.proveedor.SaveProveedorRequest;
import com.nvegas.ingwebapi.models.dto.request.proveedor.UpdateProveedorRequest;
import com.nvegas.ingwebapi.models.dto.response.error.ErrorMessageResponse;
import com.nvegas.ingwebapi.models.dto.response.proveedor.GetProveedorResponse;
import com.nvegas.ingwebapi.models.entities.JefeComprasEntity;
import com.nvegas.ingwebapi.models.entities.ProveedorEntity;
import com.nvegas.ingwebapi.services.jefeCompras.IJefeComprasService;
import com.nvegas.ingwebapi.services.proveedor.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/proveedor")
public class ProveedorController {
    @Autowired
    IProveedorService service;

    @Autowired
    IJefeComprasService jefeComprasService;

    @GetMapping
    public List<GetProveedorResponse> getList() {

        List<GetProveedorResponse> newResponse = new ArrayList<>();
        List<ProveedorEntity> response = service.getList();

        for (ProveedorEntity newItem : response) {
            newResponse.add(newItem.toResponse());
        }
        return newResponse;
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Object> getDetail(@PathVariable("id") Integer id) {


        ProveedorEntity detail = service.getDetail(id);

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
    public ResponseEntity<Object> create(@RequestBody SaveProveedorRequest request) {

        JefeComprasEntity jefeCompras = jefeComprasService.getDetail(request.getIdJefeCompras());


        if (jefeCompras == null) {
            return new ResponseEntity<>(new ErrorMessageResponse(
                    "Not Found",
                    "Not Found",
                    HttpStatus.NOT_FOUND.value(),
                    "Not Found"
            ), HttpStatus.NOT_FOUND);
        }

        ProveedorEntity newRequest = request.toEntity();
        newRequest.setJefeComprasByIdJefeCompras(jefeCompras);
        ProveedorEntity saved = service.saveOrUpdate(newRequest);

        return new ResponseEntity<>(saved.toResponse(), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody UpdateProveedorRequest request) {

        ProveedorEntity detail = service.getDetail(request.getIdProveedor());

        if (detail == null) {
            return new ResponseEntity<>(new ErrorMessageResponse(
                    "Not Found",
                    "Not Found",
                    HttpStatus.NOT_FOUND.value(),
                    "Not Found"
            ), HttpStatus.NOT_FOUND);
        }

        ProveedorEntity updatedProduct = service.saveOrUpdate(detail.update(request));

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
