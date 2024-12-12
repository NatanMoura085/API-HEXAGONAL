package com.orders.core.dtos;

import com.orders.core.enums.TypeProcess;
import com.orders.core.model.ProdutoModel;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

public class PedidoDTO {
    private Integer id;
    private OffsetDateTime dateTime;
    private TypeProcess typeProcess;
    private List<ProdutoModel> produtoModelList;

    public PedidoDTO(OffsetDateTime dateTime, TypeProcess typeProcess, List<ProdutoModel> produtoModelList) {
        this.id = id;
        this.dateTime = dateTime;
        this.typeProcess = typeProcess;
        this.produtoModelList = produtoModelList;
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
}


