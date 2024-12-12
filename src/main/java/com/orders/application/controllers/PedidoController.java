package com.orders.application.controllers;

import com.orders.core.model.Pedido;
import com.orders.core.ports.interfaces.PedidoPublish;
import com.orders.core.ports.interfaces.PedidoServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class PedidoController {
    private PedidoServicePort pedidoServicePort;
    private PedidoPublish pedidoPublish;

    public PedidoController(PedidoServicePort pedidoServicePort, PedidoPublish pedidoPublish) {
        this.pedidoServicePort = pedidoServicePort;
        this.pedidoPublish = pedidoPublish;

    }

    @GetMapping(name = "/orders")
    public List<Pedido> getAll() {
        return pedidoServicePort.listaDePedidos();
    }

    @PostMapping(name = "/orders")
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido criarPedido(@RequestBody Pedido pedido) {
        this.pedidoPublish.enviarPedido(pedido);
        return pedidoServicePort.fazerPedido(pedido);
    }
}
