package com.orders.core.ports.interfaces;

import com.orders.core.model.Pedido;

import java.util.List;

public interface PedidoServicePort {
    List<Pedido> listaDePedidos();
    void fazerPedido(Pedido pedido);
    void atualizar(Pedido pedido) throws Exception;
    void exluir(String id);

}
