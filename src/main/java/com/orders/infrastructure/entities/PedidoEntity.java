package com.orders.infrastructure.entities;

import com.orders.core.dtos.ProdutoDTO;
import com.orders.core.enums.TypeProcess;
import com.orders.core.model.Pedido;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;


@Table(name = "tb_pedidos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private OffsetDateTime dateTime;
    @Enumerated(EnumType.STRING)
    private TypeProcess typeProcess;
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProdutoEntity> produtoEntities = new ArrayList<>();
    private Double total;


    public PedidoEntity(OffsetDateTime dateTime, TypeProcess typeProcess, List<ProdutoEntity> produtoEntities) {
        this.dateTime = dateTime;
        this.typeProcess = typeProcess;
        this.produtoEntities = produtoEntities;
    }

    public PedidoEntity(Pedido pedido){
        this.dateTime = pedido.getDateTime();
        this.typeProcess = pedido.getTypeProcess();
        this.total = pedido.somaTotal();
        this.produtoEntities = pedido.getProdutoList().stream().map(ProdutoEntity::new).toList();
    }

    public Pedido toPedido() {
        return new Pedido(this.dateTime,this.typeProcess,this.produtoEntities.stream().map(ProdutoEntity::toProduto).toList());
    }


}
