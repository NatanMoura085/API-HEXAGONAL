package com.orders.application.controllers;

import com.orders.core.model.Pedido;
import com.orders.core.ports.interfaces.PedidoPublish;
import com.orders.core.ports.interfaces.PedidoServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "listaDePedidos", description = "API de gerenciamento de pedidos")
@RestController
@RequestMapping("/api/v1")
public class PedidoController {
    private PedidoServicePort pedidoServicePort;
    private PedidoPublish pedidoPublish;

    public PedidoController(PedidoServicePort pedidoServicePort,PedidoPublish pedidoPublish) {
        this.pedidoServicePort = pedidoServicePort;
       this.pedidoPublish = pedidoPublish;

    }

    @GetMapping("/orders")
    public List<Pedido> getAll() {
        return pedidoServicePort.listaDePedidos();
    }

    @Operation(summary = "Lista todos pedidos", description = "Retorna uma lista de pedidos")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/order")
    public void criarPedido(@RequestBody Pedido pedido) {
         pedidoServicePort.fazerPedido(pedido);
        this.pedidoPublish.enviarPedido(pedido);
    }
}
