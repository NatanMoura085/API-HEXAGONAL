package com.orders.infrastructure.repository;

import com.orders.infrastructure.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SpringRepository extends JpaRepository<ProdutoEntity, Long> {
    List<Double> findBypreco(Long id);
}
