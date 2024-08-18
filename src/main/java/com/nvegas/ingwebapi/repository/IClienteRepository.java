package com.nvegas.ingwebapi.repository;

import com.nvegas.ingwebapi.models.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<ClienteEntity, Integer> {
}
