package com.orders.core.ports.repositories;

import com.orders.core.dtos.PedidoDTO;
import com.orders.core.model.Pedido;
import com.orders.infrastructure.entities.ProdutoEntity;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository {
    List<Pedido> getAll();
    void salvar(Pedido pedido);
    void update(Pedido pedido);
    void delete(Integer id);
    Double calculoTotal(List<ProdutoEntity> produtoEntityList);
}
