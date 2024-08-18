package com.nvegas.ingwebapi.repository;

import com.nvegas.ingwebapi.models.entities.NaturalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INaturalRepository extends JpaRepository<NaturalEntity, Integer> {
}
