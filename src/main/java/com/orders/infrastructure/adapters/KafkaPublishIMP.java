package com.orders.infrastructure.adapters;

import com.orders.core.model.Pedido;
import com.orders.core.ports.interfaces.PedidoPublish;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class KafkaPublishIMP implements PedidoPublish {
    private KafkaTemplate<String, Set<Integer>> kafkaTemplate;

    public KafkaPublishIMP(KafkaTemplate<String,Set<Integer>> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void enviarPedido(Pedido pedido) {
        Set<Integer> key = null;
        var lista = pedido.getProdutoList().stream().filter(produt -> key.add(produt.getId()));
        kafkaTemplate.send("pedidos", key);
    }
}
