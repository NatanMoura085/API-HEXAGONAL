package com.orders.infrastructure.adapters;

import com.orders.core.model.ProdutoO;
import com.orders.core.ports.repositories.ProdutoRepository;
import com.orders.infrastructure.entities.ProdutoEntity;
import com.orders.infrastructure.repository.SpringRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ProdutoRepositoryIMP implements ProdutoRepository {
    private SpringRepository springRepository;

    public ProdutoRepositoryIMP(SpringRepository springRepository) {
        this.springRepository = springRepository;
    }

    @Override
    public void salvar(ProdutoO produto) {
        ProdutoEntity produtoEntity;
        if (Objects.isNull(produto.getQTDe())) {
            produtoEntity = new ProdutoEntity(produto);
            this.springRepository.save(produtoEntity);
        } else {
            throw new RuntimeException("deu erro");
        }

    }

    @Override
    public List<ProdutoO> listaDeProdutos() {
        List<ProdutoEntity> list = this.springRepository.findAll();
        return list.stream().map(ProdutoEntity::toProduto).collect(Collectors.toList());

    }

    @Override
    public void update(ProdutoO produto) {
        System.out.println(produto);
    }
}
