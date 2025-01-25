package com.orders.infrastructure.adapters;

import com.orders.core.model.Pedido;
import com.orders.core.ports.interfaces.PedidoPublish;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class KafkaPublishIMP implements PedidoPublish {
    private KafkaTemplate<String, Set<String>> kafkaTemplate;

    public KafkaPublishIMP(KafkaTemplate<String,Set<String>> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void enviarPedido(Pedido pedido) {
        Set<String> key = new HashSet<>();
        pedido.getProdutoList().forEach(produt -> key.add(produt.getNome()));
        kafkaTemplate.send("pedidos", key);
    }
}
