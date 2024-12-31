package nxc.hcmus.application.brokermq.rabbitmq.producer;

import nxc.hcmus.application.model.event.PostRequestEvent;
import nxc.hcmus.application.model.event.RequestEvent;

public interface PostProductProducer {
    void sendPostRequest(RequestEvent requestEvent);
}
