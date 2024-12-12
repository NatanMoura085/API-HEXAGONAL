package com.orders.core.ports.interfaces;

import com.orders.core.model.Pedido;

public interface PedidoPublish {
    void enviarPedido(Pedido pedido);
}
