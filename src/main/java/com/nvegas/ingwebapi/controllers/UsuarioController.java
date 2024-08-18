package com.nvegas.ingwebapi.controllers;

import com.nvegas.ingwebapi.models.dto.request.usuario.LoginRequest;
import com.nvegas.ingwebapi.models.dto.request.usuario.SaveUsuarioRequest;
import com.nvegas.ingwebapi.models.dto.request.usuario.UpdateUsuarioRequest;
import com.nvegas.ingwebapi.models.dto.response.error.ErrorMessageResponse;
import com.nvegas.ingwebapi.models.dto.response.usuario.GetUsuarioResponse;
import com.nvegas.ingwebapi.models.entities.JefeComprasEntity;
import com.nvegas.ingwebapi.models.entities.UsuariosEntity;
import com.nvegas.ingwebapi.services.jefeCompras.IJefeComprasService;
import com.nvegas.ingwebapi.services.usuario.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/user")
public class UsuarioController {
    @Autowired
    IUsuarioService service;

     @Autowired
    IJefeComprasService jefeComprasService;


    @GetMapping
    public List<GetUsuarioResponse> getList() {

        List<GetUsuarioResponse> newResponse = new ArrayList<>();
        List<UsuariosEntity> response = service.getList();

        for (UsuariosEntity newItem : response) {
            newResponse.add(newItem.toResponse());
        }
        return newResponse;
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Object> getDetail(@PathVariable("id") Integer id) {


        UsuariosEntity detail = service.getDetail(id);

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
    public ResponseEntity<Object> create(@RequestBody SaveUsuarioRequest request) {
        UsuariosEntity requestEntity = request.toEntity();

        if(request.getIdJefeCompras()!=null){
            JefeComprasEntity jefeCompras = jefeComprasService.getDetail(request.getIdJefeCompras());
            if(jefeCompras == null){
                return new ResponseEntity<>(new ErrorMessageResponse(
                        "Not Found",
                        "Not Found",
                        HttpStatus.NOT_FOUND.value(),
                        "Not Found"
                ), HttpStatus.NOT_FOUND);
            }
            requestEntity.setJefeComprasByIdJefeCompras(jefeCompras);
        }
        UsuariosEntity saved = service.saveOrUpdate(requestEntity);

        return new ResponseEntity<>(saved.toResponse(), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest request) {
        UsuariosEntity detail = service.login(request.getEmail(), request.getPassword());

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

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody UpdateUsuarioRequest request) {

        UsuariosEntity detail = service.getDetail(request.getIdUsuario());

        if (detail == null) {
            return new ResponseEntity<>(new ErrorMessageResponse(
                    "Not Found",
                    "Not Found",
                    HttpStatus.NOT_FOUND.value(),
                    "Not Found"
            ), HttpStatus.NOT_FOUND);
        }

        UsuariosEntity updatedProduct = service.saveOrUpdate(detail.toUpdate(request));

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
