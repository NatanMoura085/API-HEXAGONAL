package com.orders.core.model;

import com.orders.core.dtos.ProdutoDTO;

public class ProdutoO {
    private Integer id;
    private String nome;
    private int QTDe;

    public ProdutoO() {

    }

    public ProdutoO(String nome, int QTDe) {
        this.nome = nome;
        this.QTDe = QTDe;
    }

    public ProdutoO(ProdutoDTO produtoDTO) {
        this.QTDe = produtoDTO.getQTDe();
        this.nome = produtoDTO.getNome();
        this.id = produtoDTO.getId();
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
        return new ProdutoDTO(this.getId(), this.getNome(), this.QTDe);
    }
}
