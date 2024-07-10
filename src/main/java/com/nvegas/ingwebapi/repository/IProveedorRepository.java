package com.nvegas.ingwebapi.repository;

import com.nvegas.ingwebapi.models.entities.ProveedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProveedorRepository extends JpaRepository<ProveedorEntity, Integer> {
}
