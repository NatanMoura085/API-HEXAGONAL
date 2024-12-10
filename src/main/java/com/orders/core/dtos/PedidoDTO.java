package com.orders.core.dtos;

import com.orders.core.enums.TypeProcess;
import com.orders.core.model.ProdutoO;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

public class PedidoDTO {
    private UUID id;
    private OffsetDateTime dateTime;
    private TypeProcess typeProcess;
    private List<ProdutoO> produtoOList;

    public PedidoDTO(OffsetDateTime dateTime, TypeProcess typeProcess, List<ProdutoO> produtoOList) {
        this.id = id;
        this.dateTime = dateTime;
        this.typeProcess = typeProcess;
        this.produtoOList = produtoOList;
    }

    public OffsetDateTime getDateTime() {
        return dateTime;
    }

    public TypeProcess getTypeProcess() {
        return typeProcess;
    }

    public List<ProdutoO> getProdutoList() {
        return produtoOList;
    }
}


