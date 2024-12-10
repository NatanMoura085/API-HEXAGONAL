package com.orders.core.model;

import com.orders.core.enums.TypeProcess;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Integer id;
    private OffsetDateTime dateTime;
    private TypeProcess typeProcess;
    private List<ProdutoO> produtoOList;

    public Pedido(OffsetDateTime dateTime, TypeProcess typeProcess) {
        this.dateTime = dateTime;
        this.typeProcess = typeProcess;
        produtoOList = new ArrayList<>();
    }

    public void adicionarProduto(ProdutoO produtoO){
        produtoOList.add(produtoO);
    }
    public List<ProdutoO> getProdutoList(){
        return produtoOList.stream().toList();
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
}
