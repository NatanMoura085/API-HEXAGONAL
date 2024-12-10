package com.orders.infrastructure.repository;

import com.orders.infrastructure.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringRepository extends JpaRepository<ProdutoEntity, UUID> {
}
