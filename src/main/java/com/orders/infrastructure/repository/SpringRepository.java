package com.orders.infrastructure.repository;

import com.orders.infrastructure.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpringRepository extends JpaRepository<ProdutoEntity, Long> {
    @Query("SELECT p.preco FROM ProdutoEntity p WHERE p.pedido.id = :pedidoId")
    List<Double> buscarPrecosPorPedido(@Param("pedidoId") Long pedidoId);

}
