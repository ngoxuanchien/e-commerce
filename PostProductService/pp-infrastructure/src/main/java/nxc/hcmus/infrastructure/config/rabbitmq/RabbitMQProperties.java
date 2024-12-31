package nxc.hcmus.infrastructure.config.rabbitmq;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import nxc.hcmus.infrastructure.config.service.ServiceProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Getter
@RequiredArgsConstructor
public class RabbitMQProperties {

    private final ServiceProperties serviceProperties;

    @Value("${app.rabbitmq.request.exchange}")
    private String requestExchange;

    @Value("${app.rabbitmq.response.exchange}")
    private String responseExchange;

    @Value("${app.rabbitmq.response.queue.name}")
    private String queueName;

    private String routingKey;

    private String responseQueue;

    @PostConstruct
    void init() {
        routingKey = serviceProperties.getAppId();
        responseQueue = String.format("%s:%s", queueName, serviceProperties.getAppId());
    }
}
