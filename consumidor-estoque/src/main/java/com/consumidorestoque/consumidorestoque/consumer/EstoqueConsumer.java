package com.consumidorestoque.consumidorestoque.consumer;

import dto.EstoqueDto;
import constantes.RabbitmqConstantes;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EstoqueConsumer {

    @RabbitListener(queues = RabbitmqConstantes.FILA_ESTOQUE)
    private void consumidor(EstoqueDto estoqueDto) throws InterruptedException {
        System.out.println(estoqueDto.codigoProduto);
        System.out.println(estoqueDto.quantidade);
        System.out.println("--------------------------------------");

        //Thread.sleep(120000);

        throw new IllegalArgumentException("Argumento Invalido!");
    }
}
