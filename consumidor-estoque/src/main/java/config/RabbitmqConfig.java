package config;


import com.rabbitmq.client.ConnectionFactory;
import exceptions.TratamentoErroHandler;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.config.DirectRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.listener.DirectMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.context.annotation.Bean;

public class RabbitmqConfig {

    @Bean
    public RabbitListenerContainerFactory<DirectMessageListenerContainer> rabbitListenerContainerFactory(ConnectionFactory connectionFactory){
        DirectRabbitListenerContainerFactory factory = new DirectRabbitListenerContainerFactory();

        factory.setConnectionFactory((org.springframework.amqp.rabbit.connection.ConnectionFactory) connectionFactory);
        factory.setAcknowledgeMode(AcknowledgeMode.AUTO);

        factory.setPrefetchCount(4);
        factory.setGlobalQos(true);

        factory.setConsumersPerQueue(20);

        factory.setErrorHandler(new TratamentoErroHandler());

        return factory;

    }

}
