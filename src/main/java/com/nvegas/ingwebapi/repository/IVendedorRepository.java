package com.nvegas.ingwebapi.repository;

import com.nvegas.ingwebapi.models.entities.VendedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVendedorRepository extends JpaRepository<VendedorEntity, Integer> {
}
