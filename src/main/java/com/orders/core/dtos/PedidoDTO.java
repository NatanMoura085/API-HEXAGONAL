package com.orders.core.dtos;

import com.orders.core.enums.TypeProcess;
import com.orders.core.model.ProdutoModel;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PedidoDTO {
    private String id;
    private OffsetDateTime dateTime;
    private TypeProcess typeProcess;
    private List<ProdutoModel> produtoModelList;
    private Double total;

    public PedidoDTO( TypeProcess typeProcess) {
        this.id = UUID.randomUUID().toString();
        this.dateTime = OffsetDateTime.now();
        this.typeProcess = typeProcess;
        this.produtoModelList = new ArrayList<>();
    }



    public String getId() {
        return id;
    }

    public OffsetDateTime getDateTime() {
        return dateTime;
    }

    public TypeProcess getTypeProcess() {
        return typeProcess;
    }

    public List<ProdutoModel> getProdutoList() {
        return produtoModelList;
    }

    public Double getTotal() {
        return total;
    }
}


