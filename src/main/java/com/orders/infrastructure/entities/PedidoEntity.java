package com.orders.infrastructure.entities;

import com.orders.core.enums.TypeProcess;
import com.orders.core.model.Pedido;
import com.orders.core.model.ProdutoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name = "tb_pedidos")
@Data
@AllArgsConstructor
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private OffsetDateTime dateTime;
    @Enumerated(EnumType.STRING)
    private TypeProcess typeProcess;
    @OneToMany
    private List<ProdutoModel> produtoModelList;
    private Double total;

    public PedidoEntity(){

    }

    public PedidoEntity(Pedido pedido){
        this.id = pedido.getId();
        this.dateTime = pedido.getDateTime();
        this.typeProcess = pedido.getTypeProcess();
        this.produtoModelList = pedido.getProdutoList();
    }
}
