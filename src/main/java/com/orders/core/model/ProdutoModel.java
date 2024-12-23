package com.orders.core.model;

import com.orders.core.dtos.ProdutoDTO;

import java.util.UUID;

public class ProdutoModel {
    private String id;
    private String nome;
    private int QTDe;
    private double preco;
    private Pedido pedido;

    public ProdutoModel() {

    }


    public ProdutoModel(String nome, int QTDe, double preco) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.QTDe = QTDe;
        this.preco = preco;
    }

    public ProdutoModel(ProdutoDTO produtoDTO) {
        this.id = produtoDTO.getId();
        this.QTDe = produtoDTO.getQTDe();
        this.nome = produtoDTO.getNome();
        this.preco = produtoDTO.getPreco();
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getQTDe() {
        return QTDe;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQTDe(int QTDe) {
        this.QTDe = QTDe;
    }


    public ProdutoDTO toprodutoDTO() {
        return new ProdutoDTO(
                this.nome,
                this.preco,
                this.QTDe,
                this.pedido);
    }

}
