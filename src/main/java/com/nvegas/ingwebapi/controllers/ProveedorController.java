package com.nvegas.ingwebapi.controllers;

import com.nvegas.ingwebapi.models.dto.request.product.SaveProductRequest;
import com.nvegas.ingwebapi.models.dto.request.product.UpdateProductRequest;
import com.nvegas.ingwebapi.models.dto.request.proveedor.SaveProveedorRequest;
import com.nvegas.ingwebapi.models.dto.request.proveedor.UpdateProveedorRequest;
import com.nvegas.ingwebapi.models.dto.response.error.ErrorMessageResponse;
import com.nvegas.ingwebapi.models.dto.response.product.GetProductResponse;
import com.nvegas.ingwebapi.models.dto.response.proveedor.GetProveedorResponse;
import com.nvegas.ingwebapi.models.entities.ProductoEntity;
import com.nvegas.ingwebapi.models.entities.ProveedorEntity;
import com.nvegas.ingwebapi.services.product.IProductService;
import com.nvegas.ingwebapi.services.proveedor.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/proveedor")
public class ProveedorController {
    @Autowired
    IProveedorService service;

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
        ProveedorEntity saved = service.saveOrUpdate(request.toEntity());

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
