package com.orders.infrastructure.adapters;

import com.orders.core.model.ProdutoModel;
import com.orders.core.ports.repositories.ProdutoRepository;
import com.orders.infrastructure.entities.ProdutoEntity;
import com.orders.infrastructure.repository.SpringRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ProdutoRepositoryIMP implements ProdutoRepository {
    private static final Logger logger = LoggerFactory.getLogger(ProdutoRepositoryIMP.class);
    private SpringRepository springRepository;


    public ProdutoRepositoryIMP(SpringRepository springRepository) {
        this.springRepository = springRepository;
    }

    @Override
    public void salvar(ProdutoModel produto) {
        try {
            if (Objects.nonNull(produto)) {
                ProdutoEntity produtoEntity = new ProdutoEntity(produto);
                logger.info("aqui>>>>>>>>"+ String.valueOf(produtoEntity.getPreco()));
                this.springRepository.save(produtoEntity);
            } else {
                throw new IllegalArgumentException("Produto não pode ser nulo");
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro ao salvar produto", e);
        }
    }


    @Override
    public List<ProdutoModel> listaDeProdutos() {
        List<ProdutoEntity> list = this.springRepository.findAll();
        return list.stream().map(ProdutoEntity::toProduto).collect(Collectors.toList());

    }

    @Override
    public void update(ProdutoModel produto) {
        System.out.println(produto);
    }
}
