package com.orders.infrastructure.adapters;

import com.orders.core.model.Pedido;
import com.orders.core.model.ProdutoModel;
import com.orders.core.ports.repositories.PedidoRepository;
import com.orders.infrastructure.entities.PedidoEntity;
import com.orders.infrastructure.entities.ProdutoEntity;
import com.orders.infrastructure.repository.SpringPedidoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
        PedidoEntity pedidoEntity;

        if (Objects.isNull(pedido.getId())) {
            pedidoEntity = new PedidoEntity(pedido);
            pedidoEntity.setId(pedido.getId());
            pedidoEntity.setPedidoId(pedidoEntity.getPedidoId());
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
