package com.orders.application.controllers;


import com.orders.core.dtos.ProdutoDTO;
import com.orders.core.model.ProdutoModel;
import com.orders.core.ports.interfaces.ProdutoServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProdutoController {
    private ProdutoServicePort produtoServicePort;


    public ProdutoController(ProdutoServicePort produtoServicePort) {
        this.produtoServicePort = produtoServicePort;
    }

    @GetMapping("/prod")
    public List<ProdutoModel> getProduto() {
        return produtoServicePort.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarProduto(@RequestBody ProdutoDTO produtoDTO){
        this.produtoServicePort.criarProduto(produtoDTO);

    }
}
