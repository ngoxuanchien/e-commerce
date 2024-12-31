package nxc.hcmus.application.service.product;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import nxc.hcmus.application.brokermq.producer.PostProductProducer;
import nxc.hcmus.application.event.EventType;
import nxc.hcmus.application.event.MessageResponse;
import nxc.hcmus.application.event.PostEvent;
import nxc.hcmus.application.service.PostEventProcessService;
import nxc.hcmus.common.util.JsonUtil;
import nxc.hcmus.domain.model.entity.Product;
import nxc.hcmus.domain.service.product.ProductDomainService;

import java.util.Optional;

@ApplicationScoped
public class CreateProductEventProcessor implements PostEventProcessService {

    @Inject
    ProductDomainService productDomainService;

    @Inject
    JsonUtil jsonUtil;
    @Inject
    PostProductProducer postProductProducer;

    @Override
    public void processEvent(PostEvent event) {
        Optional.ofNullable(event)
                .map(PostEvent::getPayload)
                .map(payload -> jsonUtil.convertToObject(payload, Product.class))
                .map(productDomainService::createProduct)
                .ifPresent(newProduct -> {
                    var messageResponse = MessageResponse.builder()
                            .requestId(event.getRequestId())
                            .payload(newProduct)
                            .build();
                    postProductProducer.sendEvent(event.getResponseQueue().getRoutingKey(), jsonUtil.convertObjectToJson(messageResponse));
                });
    }

    @Override
    public EventType getEventType() {
        return EventType.CREATE_PRODUCT;
    }
}
