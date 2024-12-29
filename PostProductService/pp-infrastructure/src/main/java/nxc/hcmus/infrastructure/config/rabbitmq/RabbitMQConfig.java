package nxc.hcmus.infrastructure.config.rabbitmq;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class RabbitMQConfig {

    private final RabbitMQProperties rabbitMQProperties;

    @Bean
    public Queue queue() {
        return new Queue(rabbitMQProperties.getResponseQueue(), false, false, true, null);
    }

    @Bean
    public String routingKey() {
        return rabbitMQProperties.getRoutingKey();
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(rabbitMQProperties.getResponseExchange());
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange, String routingKey) {
        return BindingBuilder.bind(queue)
                .to(exchange)
                .with(routingKey);
    }
}
