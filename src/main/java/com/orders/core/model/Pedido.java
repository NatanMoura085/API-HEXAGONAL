package com.orders.core.model;

import com.orders.core.enums.TypeProcess;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Integer id;
    private OffsetDateTime dateTime;
    private TypeProcess typeProcess;
    private List<ProdutoModel> produtoModelList;
    private Double total;


    public Pedido() {

    }

    public Pedido(OffsetDateTime dateTime, TypeProcess typeProcess) {
        this.dateTime = dateTime;
        this.typeProcess = typeProcess;
        produtoModelList = new ArrayList<>();
    }

    public void adicionarProduto(String nome, int QTDe, Double preco,int  QTDE) {
        produtoModelList.add(new ProdutoModel(nome,preco,QTDe));
    }

    public List<ProdutoModel> getProdutoList() {
        return produtoModelList.stream().toList();
    }

    public Integer getId() {
        return id;
    }

    public OffsetDateTime getDateTime() {
        return dateTime;
    }

    public TypeProcess getTypeProcess() {
        return typeProcess;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDateTime(OffsetDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setTypeProcess(TypeProcess typeProcess) {
        this.typeProcess = typeProcess;
    }

    public void setProdutoModelList(List<ProdutoModel> produtoModelList) {
        this.produtoModelList = produtoModelList;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}


