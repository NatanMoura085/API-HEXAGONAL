package com.orders.core.dtos;

import com.orders.core.model.Pedido;

import java.util.UUID;

public class ProdutoDTO {
    private String id;
    private String nome;
    private double preco;
    private int QTDe;
    private Pedido pedido;

    public ProdutoDTO(String nome, double preco, int QTDe, Pedido pedido) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.preco = preco;
        this.QTDe = QTDe;
        this.pedido = pedido;
    }

    public ProdutoDTO(){

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

    public Pedido getPedido() {
        pedido = new Pedido();
        return pedido;
    }
}
