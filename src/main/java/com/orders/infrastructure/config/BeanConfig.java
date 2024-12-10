package com.orders.infrastructure.config;


import com.orders.core.adapters.ProdutoServiceIMP;
import com.orders.core.ports.interfaces.ProdutoServicePort;
import com.orders.core.ports.repositories.ProdutoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    ProdutoServicePort produtoService(ProdutoRepository produtoRepository) {
        return new ProdutoServiceIMP(produtoRepository);
    }
}
