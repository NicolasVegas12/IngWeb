package com.nvegas.ingwebapi.controllers;

import com.nvegas.ingwebapi.models.dto.request.venta.SaveDetalleVentaRequest;
import com.nvegas.ingwebapi.models.dto.request.venta.SaveVentaRequest;
import com.nvegas.ingwebapi.models.dto.response.error.ErrorMessageResponse;
import com.nvegas.ingwebapi.models.dto.response.venta.GetVentaResponse;
import com.nvegas.ingwebapi.models.entities.*;
import com.nvegas.ingwebapi.services.cliente.IClienteService;
import com.nvegas.ingwebapi.services.product.IProductService;
import com.nvegas.ingwebapi.services.vendedor.IVendedorService;
import com.nvegas.ingwebapi.services.ventas.IVentaService;
import com.nvegas.ingwebapi.services.ventas.detalle.IDetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/venta")
public class VentaController {

    @Autowired
    IVentaService service;

    @Autowired
    IDetalleVentaService detalleVentaService;
    @Autowired
    IVendedorService vendedorService;

    @Autowired
    IClienteService clienteService;

    @Autowired
    IProductService productService;

    @GetMapping
    public List<GetVentaResponse> getList() {

        List<GetVentaResponse> newResponse = new ArrayList<>();
        List<VentaEntity> response = service.getList();

        for (VentaEntity newItem : response) {
            newResponse.add(newItem.toResponse());
        }
        return newResponse;
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Object> getDetail(@PathVariable("id") Integer id) {
        VentaEntity detail = service.getDetail(id);
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
    public ResponseEntity<Object> create(@RequestBody SaveVentaRequest request) {

        VendedorEntity vendedor = vendedorService.getDetail(request.getIdVendedor());
        ClienteEntity cliente = clienteService.getDetail(request.getIdCliente());

        if (vendedor == null || cliente == null) {
            return new ResponseEntity<>(new ErrorMessageResponse(
                    "Not Found",
                    "Not Found",
                    HttpStatus.NOT_FOUND.value(),
                    "Not Found"
            ), HttpStatus.NOT_FOUND);
        }


        VentaEntity entity = request.toEntity();
        entity.setClienteByIdCliente(cliente);
        entity.setVendedorByIdVendedor(vendedor);

        List<DetalleVentaEntity> newDetalleList = new ArrayList<>();
        VentaEntity saved = service.saveOrUpdate(entity);

        for (SaveDetalleVentaRequest newItem : request.getDetalleVenta()) {

            VentaEntity venta = service.getDetail(saved.getIdVenta());

            DetalleVentaEntity detalleEntity = new DetalleVentaEntity();
            ProductoEntity producto = productService.getProductDetail(newItem.getIdProducto());

            detalleEntity.setCantidad(newItem.getCantidad());
            detalleEntity.setMontoUnitario(producto.getPrecio());
            detalleEntity.setMonto(producto.getPrecio() * newItem.getCantidad());
            detalleEntity.setProductoByIdProducto(producto);
            detalleEntity.setVentaByIdVenta(venta);
           DetalleVentaEntity newDetalle =  detalleVentaService.saveOrUpdate(detalleEntity);
           newDetalleList.add(newDetalle);
           producto.setStock(producto.getStock()-newItem.getCantidad());
           productService.saveOrUpdateProduct(producto);

        }


        VentaEntity newSaved = service.getDetail(saved.getIdVenta());
        newSaved.setDetalleVentasByIdVenta(newDetalleList);

        return new ResponseEntity<>(newSaved.toResponse(), HttpStatus.CREATED);
    }

/*    @PutMapping
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
