package com.orders.infrastructure.adapters;

import com.orders.core.model.Pedido;
import com.orders.core.model.ProdutoModel;
import com.orders.core.ports.repositories.PedidoRepository;
import com.orders.infrastructure.entities.PedidoEntity;
import com.orders.infrastructure.entities.ProdutoEntity;
import com.orders.infrastructure.repository.SpringPedidoRepository;
import com.orders.infrastructure.repository.SpringRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class PedidoRepositoryIMP implements PedidoRepository {
    private SpringPedidoRepository springPedidoRepository;
    private SpringRepository springRepository;


    public PedidoRepositoryIMP(SpringPedidoRepository springPedidoRepository,SpringRepository springRepository) {

        this.springPedidoRepository = springPedidoRepository;
        this.springRepository = springRepository;
    }

    @Override
    public List<Pedido> getAll() {
        return springPedidoRepository.findAll().stream().map(PedidoEntity::toPedido).toList();
    }

    @Override
    public void salvar(Pedido pedido) {
        if (Objects.isNull(pedido)) {
            throw new IllegalArgumentException("Pedido não pode ser nulo.");
        }
        PedidoEntity pedidoEntity = new PedidoEntity(pedido);

        pedidoEntity = this.springPedidoRepository.save(pedidoEntity);

    }


    @Override
    public void update(Pedido pedido) {
        PedidoEntity pedidoEntity;

        if (Objects.nonNull(pedido.getId())) {
            pedidoEntity = new PedidoEntity(pedido);
            pedidoEntity.setTotal(pedido.getTotal());
            pedidoEntity.setId(Long.parseLong(pedido.getId()));
            pedidoEntity.setTypeProcess(pedido.getTypeProcess());
            pedidoEntity.setDateTime(pedido.getDateTime());
            pedidoEntity.setTotal(pedido.getTotal());
            springPedidoRepository.save(pedidoEntity);
        }

    }

    @Override
    public void delete(Integer id) {
        PedidoEntity pedidoEntity = springPedidoRepository.findById(id).orElseThrow();
        this.springPedidoRepository.delete(pedidoEntity);
    }
}
