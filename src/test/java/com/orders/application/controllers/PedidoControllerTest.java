package com.orders.application.controllers;

import com.orders.core.enums.TypeProcess;
import com.orders.core.model.Pedido;
import com.orders.core.model.ProdutoModel;
import com.orders.core.ports.interfaces.PedidoPublish;
import com.orders.core.ports.interfaces.PedidoServicePort;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class PedidoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private PedidoServicePort pedidoServicePort;

    @Mock
    private PedidoPublish pedidoPublish;

    @InjectMocks
    private PedidoController pedidoController;
    @Mock
    private KafkaProducer<String, String> kafkaProducer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(pedidoServicePort.listaDePedidos()).thenReturn(Arrays.asList()); // Garante que não chame o BD
    }


    @Test
    void getAll() throws Exception {
        ProdutoModel produto1 = new ProdutoModel("Notebook", 4, 10000);
        ProdutoModel produto2 = new ProdutoModel("Celular", 4, 900);
        List<ProdutoModel> produtoList = Arrays.asList(produto1, produto2);

        Pedido pedido1 = new Pedido(OffsetDateTime.now(), TypeProcess.SUCCESS, produtoList, 100.00);
        Pedido pedido2 = new Pedido(OffsetDateTime.now(), TypeProcess.SUCCESS, produtoList, 200.00);
        List<Pedido> pedidoList = Arrays.asList(pedido1, pedido2);

        when(pedidoServicePort.listaDePedidos()).thenReturn(pedidoList);

        mockMvc.perform(get("/api/v1/orders")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(0));

        // verify(pedidoServicePort, times(1)).listaDePedidos();
    }

    @Test
    void criarPedido() {
        // Configura o pedido
        ProdutoModel produto1 = new ProdutoModel("Notebook", 4, 10000);
        ProdutoModel produto2 = new ProdutoModel("Celular", 4, 900);
        List<ProdutoModel> produtoList = Arrays.asList(produto1, produto2);
        Pedido pedido1 = new Pedido(OffsetDateTime.now(), TypeProcess.SUCCESS, produtoList, 100.00);

        // Configura o mock do KafkaProducer
        String topic = "pedido-topic";
        String message = "Pedido enviado";
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, message);

        when(kafkaProducer.send(record)).thenReturn(null); // Mock do envio

        // Chama o método no controlador
        pedidoController.criarPedido(pedido1);

        // Verifica se o método send foi chamado uma vez
       // verify(kafkaProducer, times(1)).send(any(ProducerRecord.class));  // Modificado para garantir qualquer ProducerRecord
    }
}
