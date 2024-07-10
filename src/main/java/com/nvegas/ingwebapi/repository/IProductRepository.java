package com.nvegas.ingwebapi.repository;

import com.nvegas.ingwebapi.models.entities.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository  extends JpaRepository<ProductoEntity,Integer> {

}
