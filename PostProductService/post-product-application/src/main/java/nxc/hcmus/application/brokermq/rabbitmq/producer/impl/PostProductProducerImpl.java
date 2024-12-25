package nxc.hcmus.application.brokermq.rabbitmq.producer.impl;

import lombok.RequiredArgsConstructor;
import nxc.hcmus.application.brokermq.rabbitmq.producer.PostProductProducer;
import nxc.hcmus.application.model.event.PostEvent;
import nxc.hcmus.common.util.JsonUtil;
import nxc.hcmus.domain.model.events.AbstractEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostProductProducerImpl implements PostProductProducer {

    private final RabbitTemplate rabbitTemplate;

    private final JsonUtil jsonUtil;

    // todo: implement the method to send post product
    @Override
    public void sendPostProduct(PostEvent event) {
        String payload = jsonUtil.convertObjectToJson(event);
        rabbitTemplate.convertAndSend(
                "post-product-request",
                "",
                payload.getBytes()
        );
    }
}
