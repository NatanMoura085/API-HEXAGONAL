package com.orders.core.model;

import com.orders.core.dtos.ProdutoDTO;

public class ProdutoModel {
    private Integer id;
    private String nome;
    private int QTDe;
    private Double preco;

    public ProdutoModel() {

    }

    public ProdutoModel(String nome,Double preco, int QTDe) {
        this.nome = nome;
        this.preco =preco;
        this.QTDe = QTDe;
    }

    public ProdutoModel(ProdutoDTO produtoDTO) {
        this.QTDe = produtoDTO.getQTDe();
        this.nome = produtoDTO.getNome();
        this.id = produtoDTO.getId();
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
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
