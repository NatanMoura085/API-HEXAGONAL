package com.orders.core.ports.interfaces;

import com.orders.core.dtos.ProdutoDTO;
import com.orders.core.model.ProdutoO;

import java.util.List;

public interface ProdutoServicePort {
    List<ProdutoO> getAll();

    void criarProduto(ProdutoDTO produtoDTO);

    void autualizarProduto(ProdutoDTO produtoDTO);

}
