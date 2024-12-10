package com.orders.core.adapters;

import com.orders.core.dtos.ProdutoDTO;
import com.orders.core.model.ProdutoO;
import com.orders.core.ports.interfaces.ProdutoServicePort;
import com.orders.core.ports.repositories.ProdutoRepository;

import java.util.List;

public class ProdutoServiceIMP implements ProdutoServicePort {
    private ProdutoRepository produtoRepository;


    public ProdutoServiceIMP(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }


    @Override
    public List<ProdutoO> getAll() {
        List<ProdutoO> produtoOList = this.produtoRepository.listaDeProdutos();
        //List<ProdutoO> tranformEntity = produtoOList.stream().map(ProdutoO::toprodutoDTO).collect(Collectors.toList());
        return produtoOList;

    }

    @Override
    public void criarProduto(ProdutoDTO produtoDTO) {
        ProdutoO produtoO = new ProdutoO(produtoDTO);
        this.produtoRepository.salvar(produtoO);

    }

    @Override
    public void autualizarProduto(ProdutoDTO produtoDTO) {
        ProdutoO produtoO = new ProdutoO(produtoDTO);
        this.produtoRepository.update(produtoO);

    }
}
