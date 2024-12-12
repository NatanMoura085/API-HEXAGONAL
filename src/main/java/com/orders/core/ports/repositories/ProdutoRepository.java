package com.orders.core.ports.repositories;

import com.orders.core.model.ProdutoModel;

import java.util.List;

public interface ProdutoRepository {
    void salvar(ProdutoModel produto);

    List<ProdutoModel> listaDeProdutos();

    void update(ProdutoModel produto);

}
