package com.orders.infrastructure.entities;

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
//    @ManyToOne
//    private Pedido pedido;


    public ProdutoEntity(ProdutoModel produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
        this.QTDe = produto.getQTDe();
    }


    public ProdutoModel toProduto() {
        return new ProdutoModel(this.nome,this.preco, this.QTDe);
    }

}
