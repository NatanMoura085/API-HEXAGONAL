package com.orders.infrastructure.entities;

import com.orders.core.dtos.ProdutoDTO;
import com.orders.core.model.ProdutoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "tb_produtos")
@AllArgsConstructor
@Data
public class ProdutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private double preco;
    private int QTDe;
    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private PedidoEntity pedido;

    public ProdutoEntity(){

    }

    public ProdutoEntity(ProdutoModel produto) {
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
        this.QTDe = produto.getQTDe();
    }

    public ProdutoEntity(ProdutoDTO produtoDTO){
        this.nome = produtoDTO.getNome();
        this.preco = produtoDTO.getPreco();
        this.QTDe = produtoDTO.getQTDe();

    }

    public ProdutoModel toProduto() {
        return new ProdutoModel(this.nome, this.QTDe, this.preco, new ProdutoDTO().getPedido());
    }

}
