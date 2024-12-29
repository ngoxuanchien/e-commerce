package nxc.hcmus.application.brokermq.rabbitmq.consumer.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nxc.hcmus.application.brokermq.rabbitmq.consumer.PostProductConsumer;
import nxc.hcmus.application.model.event.PostResponseEvent;
import nxc.hcmus.application.service.deferresult.DeferredResultService;
import nxc.hcmus.common.util.JsonUtil;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class PostProductConsumerImpl implements PostProductConsumer {

    private final DeferredResultService deferredResultService;

    private final JsonUtil jsonUtil;

    @Override
    @RabbitListener(queues = "#{queue.getName()}")
    public void consumePostProductResponse(String message) {
        System.out.println("Received message: " + message);
        var postResponse = jsonUtil.convertJsonToObject(message, PostResponseEvent.class);
        deferredResultService.setResult(postResponse.getRequestId(), postResponse.getPayload());
    }
}
