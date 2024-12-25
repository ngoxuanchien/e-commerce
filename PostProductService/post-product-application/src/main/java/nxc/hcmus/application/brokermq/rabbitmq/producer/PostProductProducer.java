package nxc.hcmus.application.brokermq.rabbitmq.producer;

import nxc.hcmus.application.model.event.PostEvent;
import nxc.hcmus.domain.model.events.AbstractEvent;

public interface PostProductProducer {
    void sendPostProduct(PostEvent event);
}
