package com.nvegas.ingwebapi.services.product;


import com.nvegas.ingwebapi.models.entities.ProductoEntity;
import com.nvegas.ingwebapi.repository.IProductRepository;
import jakarta.annotation.Nullable;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class ProductService implements IProductService {

    @Autowired
    IProductRepository productRepository;

    @Override
    public List<ProductoEntity> getProduct() {
        return productRepository.findAll();
    }

    @Override
    @Nullable
    public ProductoEntity getProductDetail(Integer productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    public ProductoEntity saveOrUpdateProduct(ProductoEntity product) {
        return productRepository.save(product);
    }

    @Override
    public Boolean deleteProduct(Integer id) {
        if (!productRepository.existsById(id)) {
            return false;
        }
        productRepository.deleteById(id);
        return true;
    }

}
