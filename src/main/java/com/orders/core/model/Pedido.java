package com.orders.core.model;

import com.orders.core.dtos.PedidoDTO;
import com.orders.core.enums.TypeProcess;
import com.orders.infrastructure.entities.PedidoEntity;
import com.orders.infrastructure.entities.ProdutoEntity;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pedido {
    private Integer id;
    private OffsetDateTime dateTime;
    private TypeProcess typeProcess;
    private List<ProdutoModel> produtoModelList;
    private Double total;


    public Pedido() {

    }

    public Pedido(TypeProcess typeProcess) {
        this.dateTime = OffsetDateTime.now();
        this.typeProcess = typeProcess;
        produtoModelList = new ArrayList<>();
    }

    public Pedido(PedidoDTO pedidoDTO){
        this.id = pedidoDTO.getId();
        this.dateTime = pedidoDTO.getDateTime();
        this.typeProcess = pedidoDTO.getTypeProcess();
        this.produtoModelList = pedidoDTO.getProdutoList();
        this.total = pedidoDTO.getTotal();
    }

    public Pedido(Integer id, OffsetDateTime dateTime, TypeProcess typeProcess, List<ProdutoModel> produtoModelList, Double total) {
        this.id = id;
        this.dateTime = dateTime;
        this.typeProcess = typeProcess;
        this.produtoModelList =  new ArrayList<>(produtoModelList);
        this.total = total;
    }

    public void adicionarProduto(String nome, int QTDe, Double preco, int  QTDE) {
        produtoModelList.add(new ProdutoModel(nome,preco,QTDe));
    }

    public List<ProdutoModel> getProdutoList() {
         if (Objects.isNull(produtoModelList)){
             throw new RuntimeException("Esta sem pedidos");

         }
        return produtoModelList.stream().toList();
    }

    public Integer getId() {
        return id;
    }

    public Double getTotal() {
        return total;
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


