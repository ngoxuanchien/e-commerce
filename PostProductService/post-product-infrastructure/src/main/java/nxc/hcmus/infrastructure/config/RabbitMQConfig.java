package nxc.hcmus.infrastructure.config;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@RequiredArgsConstructor
@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE_NAME = "post-product-response";
    public static final String ROUTING_KEY = UUID.randomUUID().toString();
    public static final String QUEUE_NAME = "post-product-" + UUID.randomUUID();
//
//    @Bean
//    Queue queue() {
//        return new Queue(QUEUE_NAME, false, false, true, null);
//    }
//
//    @Bean
//    TopicExchange exchange() {
//        return new TopicExchange(EXCHANGE_NAME);
//    }
//
//    @Bean
//    public FanoutExchange fanoutExchange() {
//        return new FanoutExchange("post-product-request");
//    }
//
//    @Bean
//    Binding binding(Queue queue, TopicExchange exchange) {
//        return BindingBuilder.bind(queue)
//                .to(exchange)
//                .with(ROUTING_KEY);
//    }
}
