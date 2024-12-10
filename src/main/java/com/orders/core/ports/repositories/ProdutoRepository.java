package com.orders.core.ports.repositories;

import com.orders.core.model.ProdutoO;

import java.util.List;

public interface ProdutoRepository {
    void salvar(ProdutoO produto);

    List<ProdutoO> listaDeProdutos();

    void update(ProdutoO produto);

}
