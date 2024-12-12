package com.orders.infrastructure.adapters;

import com.orders.core.model.Pedido;
import com.orders.core.ports.interfaces.PedidoPublish;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaPublishIMP implements PedidoPublish {
    private KafkaTemplate<String, Integer> kafkaTemplate;

    @Override
    public void enviarPedido(Pedido pedido) {
        kafkaTemplate.send("pedidos", pedido.getId());
    }
}
