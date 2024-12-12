package com.orders.infrastructure.config;


import com.orders.core.adapters.PedidoServiceIMP;
import com.orders.core.adapters.ProdutoServiceIMP;
import com.orders.core.ports.interfaces.PedidoServicePort;
import com.orders.core.ports.interfaces.ProdutoServicePort;
import com.orders.core.ports.repositories.PedidoRepository;
import com.orders.core.ports.repositories.ProdutoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    ProdutoServicePort produtoService(ProdutoRepository produtoRepository) {
        return new ProdutoServiceIMP(produtoRepository);
    }

    @Bean
    PedidoServicePort pedidoService(PedidoRepository pedidoRepository) {
        return new PedidoServiceIMP(pedidoRepository);
    }
}
