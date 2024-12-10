package com.orders.core.dtos;

public class ProdutoDTO {
    private Integer id;
    private String nome;
    private int QTDe;


    public ProdutoDTO(Integer id, String nome, int QTDe) {
        this.id = id;
        this.nome = nome;
        this.QTDe = QTDe;
    }

    public ProdutoDTO(){

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
}
