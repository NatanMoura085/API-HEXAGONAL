package com.orders.core.adapters;

import com.orders.core.dtos.ProdutoDTO;
import com.orders.core.model.ProdutoModel;
import com.orders.core.ports.interfaces.ProdutoServicePort;
import com.orders.core.ports.repositories.ProdutoRepository;

import java.util.List;

public class ProdutoServiceIMP implements ProdutoServicePort {
    private ProdutoRepository produtoRepository;


    public ProdutoServiceIMP(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }


    @Override
    public List<ProdutoModel> getAll() {
        List<ProdutoModel> produtoModelList = this.produtoRepository.listaDeProdutos();
        //List<ProdutoO> tranformEntity = produtoOList.stream().map(ProdutoO::toprodutoDTO).collect(Collectors.toList());
        return produtoModelList;

    }

    @Override
    public void criarProduto(ProdutoDTO produtoDTO) {
        ProdutoModel produtoModel = new ProdutoModel(produtoDTO);
        this.produtoRepository.salvar(produtoModel);

    }

    @Override
    public void autualizarProduto(ProdutoDTO produtoDTO) {
        ProdutoModel produtoModel = new ProdutoModel(produtoDTO);
        this.produtoRepository.update(produtoModel);

    }
}
