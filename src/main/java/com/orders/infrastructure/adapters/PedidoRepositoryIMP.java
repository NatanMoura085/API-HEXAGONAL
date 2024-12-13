package com.orders.infrastructure.adapters;

import com.orders.core.model.Pedido;
import com.orders.core.ports.repositories.PedidoRepository;
import com.orders.infrastructure.entities.PedidoEntity;
import com.orders.infrastructure.repository.SpringPedidoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class PedidoRepositoryIMP implements PedidoRepository {
    private SpringPedidoRepository springPedidoRepository;

    public PedidoRepositoryIMP(SpringPedidoRepository springPedidoRepository) {
        this.springPedidoRepository = springPedidoRepository;
    }

    @Override
    public List<Pedido> getAll() {
        return springPedidoRepository.findAll().stream().map(PedidoEntity::toPedido).toList();
    }

    @Override
    public void salvar(Pedido pedido) {
        PedidoEntity pedidoEntity;

        if (Objects.isNull(pedido.getId())) {
            pedidoEntity = new PedidoEntity(pedido);
        } else {

            throw new RuntimeException("deu erro");

        }
        this.springPedidoRepository.save(pedidoEntity);
    }

    @Override
    public void update(Pedido pedido) {

    }

    @Override
    public void delete(Integer id) {
        Optional<PedidoEntity> pedidoEntity = springPedidoRepository.findById(id);
        this.springPedidoRepository.delete(pedidoEntity);
    }
}
