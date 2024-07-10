package com.nvegas.ingwebapi.controllers;


import com.nvegas.ingwebapi.models.dto.response.error.ErrorMessageResponse;
import com.nvegas.ingwebapi.models.entities.ProductoEntity;
import com.nvegas.ingwebapi.services.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/products")
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping
    public List<ProductoEntity> getProducts() {
        return productService.getProduct();
    }

    @GetMapping(path = "{productId}")
    public ResponseEntity<Object> getProductDetail(@PathVariable("productId") Integer id) {


        ProductoEntity detail = productService.getProductDetail(id);

        if (detail == null) {
            return new ResponseEntity<>( new ErrorMessageResponse(
                    "Product Not Found",
                    "Product Not Found",
                    HttpStatus.NOT_FOUND.value(),
                    "Product Not Found"
            ),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(detail, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createProduct(@RequestBody ProductoEntity product) {
        ProductoEntity savedProduct = productService.saveOrUpdateProduct(product);

        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> updateProduct(@RequestBody ProductoEntity product) {
        ProductoEntity updatedProduct = productService.saveOrUpdateProduct(product);

        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);

    }

    @DeleteMapping(path = "{productId}")
    public ResponseEntity<Object> deleteProduct(@PathVariable("productId") Integer id) {
        Boolean deleted = productService.deleteProduct(id);
        if (Boolean.FALSE.equals(deleted)) {
            return new ResponseEntity<>(
                    new ErrorMessageResponse(
                            "Product Not Found",
                            "Product Not Found",
                            HttpStatus.NOT_FOUND.value(),
                            "Product Not Found"
                    ),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
