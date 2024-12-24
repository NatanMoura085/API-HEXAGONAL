package com.orders.infrastructure.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.orders.core.dtos.ProdutoDTO;
import com.orders.core.model.Pedido;
import com.orders.core.model.ProdutoModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "tb_produtos")
@AllArgsConstructor
@Data
public class ProdutoEntity {
    private static final Logger logger = LoggerFactory.getLogger(ProdutoEntity.class);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String nome ;
    @PositiveOrZero
    private double preco;
    private int QTDe;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "pedido_id", referencedColumnName = "id")
    @JsonBackReference
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

    public ProdutoEntity(Pedido pedido) {
       mapProdAdd(pedido);
    }



    public void mapProdAdd(Pedido pedido){
        this.pedido = new PedidoEntity(pedido);
        for (ProdutoModel p : pedido.getProdutoList()) {
            ProdutoEntity produtoEntity = new ProdutoEntity();
            produtoEntity.setNome(p.getNome());
            produtoEntity.setPreco(p.getPreco());
            produtoEntity.setQTDe(p.getQTDe());
            produtoEntity.setPedido(this.pedido);
            this.pedido.getProdutoEntities().add(produtoEntity);
            logger.info("aqui>>>>>>>"+ produtoEntity.getNome());
        }
    }
    public ProdutoModel toProduto() {
        return new ProdutoModel(this.nome, this.QTDe, this.preco);
    }

}
