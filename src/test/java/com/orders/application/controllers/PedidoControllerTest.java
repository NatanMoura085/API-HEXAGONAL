package com.orders.application.controllers;

import com.orders.core.enums.TypeProcess;
import com.orders.core.model.Pedido;
import com.orders.core.model.ProdutoModel;
import com.orders.core.ports.interfaces.PedidoPublish;
import com.orders.core.ports.interfaces.PedidoServicePort;
import org.apache.kafka.clients.producer.MockProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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

    private MockProducer<String, String> mockProducer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        mockProducer = new MockProducer<>(true, new StringSerializer(), new StringSerializer());

        when(pedidoServicePort.listaDePedidos()).thenReturn(Arrays.asList());
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
    }

    @Test
    void criarPedido_DeveEnviarMensagemParaKafka() {
        String topic = "pedido-topic";
        String message = "Pedido enviado";
        ProdutoModel produto1 = new ProdutoModel("Notebook", 4, 10000);
        ProdutoModel produto2 = new ProdutoModel("Celular", 4, 900);
        List<ProdutoModel> produtoList = Arrays.asList(produto1, produto2);
        Pedido pedido1 = new Pedido(OffsetDateTime.now(), TypeProcess.SUCCESS, produtoList, 100.00);
        when(pedidoServicePort.fazerPedido(any(Pedido.class))).thenReturn(pedido1);

        mockProducer.send(new ProducerRecord<>(topic, message));

        pedidoController.criarPedido(pedido1);

        assertFalse(mockProducer.history().isEmpty(), "Nenhuma mensagem foi enviada para o Kafka!");

        ProducerRecord<String, String> recordEnviado = mockProducer.history().get(0);
        assertEquals(topic, recordEnviado.topic());
        assertEquals(message, recordEnviado.value());

        verify(pedidoPublish, times(1)).enviarPedido(any(Pedido.class));
    }
}
