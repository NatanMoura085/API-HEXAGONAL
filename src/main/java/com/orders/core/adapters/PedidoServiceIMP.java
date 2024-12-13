package com.orders.core.adapters;

import com.orders.core.dtos.PedidoDTO;
import com.orders.core.model.Pedido;
import com.orders.core.ports.interfaces.PedidoServicePort;
import com.orders.core.ports.repositories.PedidoRepository;
import org.apache.kafka.shaded.com.google.protobuf.Internal;

import java.util.List;

public class PedidoServiceIMP implements PedidoServicePort {
    private PedidoRepository pedidoRepository;

    public PedidoServiceIMP(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public List<Pedido> listaDePedidos() {
        return pedidoRepository.getAll();
    }

    @Override
    public Pedido fazerPedido(Pedido pedido) {
        this.pedidoRepository.salvar(pedido); ;
        return pedido;
    }



    @Override
    public void atualizar(Pedido pedido) throws Exception {
        List<Pedido> pedidoList = this.pedidoRepository.getAll();
        if (!pedidoList.contains(pedido.getId())) {
            throw new Exception("id nao existe");
        }
            pedidoList.add(new Pedido(pedido.getTypeProcess()));

        this.pedidoRepository.update(pedido);
    }

    @Override
    public void exluir(Integer id) {

    }
}
