package nxc.hcmus.application.brokermq.rabbitmq.producer;

import nxc.hcmus.application.model.event.PostRequestEvent;

public interface PostProductProducer {
    void sendPostProduct(PostRequestEvent event);
}
