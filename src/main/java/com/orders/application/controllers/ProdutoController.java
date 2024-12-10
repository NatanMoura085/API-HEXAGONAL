package com.orders.application.controllers;


import com.orders.core.dtos.ProdutoDTO;
import com.orders.core.model.ProdutoO;
import com.orders.core.ports.interfaces.ProdutoServicePort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ProdutoController {
    private ProdutoServicePort produtoServicePort;


    public ProdutoController(ProdutoServicePort produtoServicePort) {
        this.produtoServicePort = produtoServicePort;
    }

    @GetMapping("/prod")
    public List<ProdutoO> getProduto() {
        return produtoServicePort.getAll();
    }
}
