package com.nvegas.ingwebapi.repository;

import com.nvegas.ingwebapi.models.entities.DetalleVentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetalleVentaRepository extends JpaRepository<DetalleVentaEntity, Integer> {
}
