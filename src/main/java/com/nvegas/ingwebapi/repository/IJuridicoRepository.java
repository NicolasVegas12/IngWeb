package com.nvegas.ingwebapi.repository;

import com.nvegas.ingwebapi.models.entities.JuridicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJuridicoRepository extends JpaRepository<JuridicoEntity, Integer> {
}
