package com.nvegas.ingwebapi.services.product;

import com.nvegas.ingwebapi.models.entities.ProductoEntity;
import jakarta.annotation.Nullable;

import java.util.List;

public interface IProductService {
    List<ProductoEntity> getProduct();
    ProductoEntity saveOrUpdateProduct(ProductoEntity product);
    Boolean deleteProduct(Integer id);

    @Nullable
    ProductoEntity getProductDetail(Integer productId);
}
