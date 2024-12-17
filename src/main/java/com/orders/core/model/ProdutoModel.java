package com.orders.core.model;

import com.orders.core.dtos.ProdutoDTO;
import com.orders.infrastructure.entities.ProdutoEntity;

public class ProdutoModel {
    private Integer id;
    private String nome;
    private int QTDe;
    private double preco;

    public ProdutoModel() {

    }

    public ProdutoModel(String nome,Double preco, int QTDe) {
        this.nome = nome;
        this.preco =preco;
        this.QTDe = QTDe;
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

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getQTDe() {
        return QTDe;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQTDe(int QTDe) {
        this.QTDe = QTDe;
    }


    public ProdutoDTO toprodutoDTO() {
        return new ProdutoDTO(this.getId(), this.getNome(),this.preco, this.QTDe);
    }

}
