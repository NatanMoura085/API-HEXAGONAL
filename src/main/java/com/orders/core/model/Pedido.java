package com.orders.core.model;

import com.orders.core.dtos.PedidoDTO;
import com.orders.core.enums.TypeProcess;
import com.orders.infrastructure.entities.PedidoEntity;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Pedido {
    private String id;
    private OffsetDateTime dateTime;
    private TypeProcess typeProcess;
    private List<ProdutoModel> produtoModelList = new ArrayList<>();;
    private Double total;


    public Pedido() {

    }

    public Pedido(TypeProcess typeProcess) {
        this.id = UUID.randomUUID().toString();
        this.dateTime = OffsetDateTime.now();
        this.typeProcess = typeProcess;
        produtoModelList = new ArrayList<>();
    }

    public Pedido(PedidoDTO pedidoDTO){
        this.id = pedidoDTO.getId();
        this.dateTime = pedidoDTO.getDateTime();
        this.typeProcess = pedidoDTO.getTypeProcess();
        this.produtoModelList = (pedidoDTO.getProdutoList() == null) ? new ArrayList<>() : pedidoDTO.getProdutoList();
        this.total = pedidoDTO.getTotal();
    }

    public Pedido(OffsetDateTime dateTime, TypeProcess typeProcess, List<ProdutoModel> produtoModelList) {
        this.id = UUID.randomUUID().toString();
        this.dateTime = dateTime;
        this.typeProcess = typeProcess;
        this.produtoModelList =  produtoModelList;
        // this.total = somaTotal(produtoModelList);
    }

    public void adicionarProduto(String nome, int QTDe, double preco) {
        produtoModelList.add(new ProdutoModel(nome,QTDe, preco));
    }

    public double somaTotal(Object value) {
        if (value == null) {
            throw new NullPointerException("esta nulo ou nao tem valor");
        }
        if (value instanceof Pedido pedido) {
            return pedido.getProdutoList().stream()
                    .mapToDouble(produto -> produto.getPreco() * produto.getQTDe()).sum();

        } else if (value instanceof PedidoEntity pedidoEntity) {
            return pedidoEntity.getProdutoEntities().stream()
                    .mapToDouble(produto -> produto.getPreco() * produto.getQTDe()).sum();
        } else if (value instanceof List<?> lista) {
            lista = (List<?>) new ProdutoModel();
            return lista.stream().mapToDouble(this::somaTotal).sum();
        }
        throw new IllegalArgumentException("valor nao suportado");

    }
    public List<ProdutoModel> getProdutoList() {
        return produtoModelList == null ? new ArrayList<>() : produtoModelList;
    }

    public String getId() {
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

    public void setId(String id) {
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


