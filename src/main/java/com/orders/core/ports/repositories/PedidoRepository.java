package com.orders.core.ports.repositories;

import com.orders.core.model.Pedido;

import java.util.List;

public interface PedidoRepository {
    List<Pedido> getAll();
    void salvar(Pedido pedido);
    void update(Pedido pedido);
    void delete(String id);
}
