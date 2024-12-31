package nxc.hcmus.application.brokermq.rabbitmq.producer.impl;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import nxc.hcmus.application.brokermq.rabbitmq.producer.PostProductProducer;
import nxc.hcmus.application.model.event.PostRequestEvent;
import nxc.hcmus.application.model.event.RequestEvent;
import nxc.hcmus.application.model.event.ResponseQueue;
import nxc.hcmus.common.util.JsonUtil;
import nxc.hcmus.infrastructure.config.rabbitmq.RabbitMQProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostProductProducerImpl implements PostProductProducer {

    private final RabbitTemplate rabbitTemplate;

    private final JsonUtil jsonUtil;

    private final RabbitMQProperties rabbitMQProperties;

    private ResponseQueue responseQueue;

    @PostConstruct
    void init() {
        responseQueue = ResponseQueue.builder()
                .exchange(rabbitMQProperties.getResponseExchange())
                .routingKey(rabbitMQProperties.getRoutingKey())
                .build();
    }

    @Override
    public void sendPostRequest(RequestEvent requestEvent) {
        requestEvent.setResponseQueue(responseQueue);

        send(jsonUtil.convertObjectToJson(requestEvent));
    }

    private void send(String payload) {
        rabbitTemplate.convertAndSend(
                rabbitMQProperties.getRequestExchange(),
                "",
                payload.getBytes()
        );
    }
}
