package com.orders.infrastructure.entities;

import com.orders.core.model.ProdutoO;
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
    private int QTDe;

    public ProdutoEntity() {

    }

    public ProdutoEntity(ProdutoO produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.QTDe = produto.getQTDe();
    }


    public ProdutoO toProduto() {
        return new ProdutoO(this.nome, this.QTDe);
    }

}
