package com.orders.infrastructure.repository;

import com.orders.infrastructure.entities.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringPedidoRepository extends JpaRepository<PedidoEntity, Integer> {
}
