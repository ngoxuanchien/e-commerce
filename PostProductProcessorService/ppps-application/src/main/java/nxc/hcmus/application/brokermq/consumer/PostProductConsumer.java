package nxc.hcmus.application.brokermq.consumer;

import io.smallrye.reactive.messaging.annotations.Blocking;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import nxc.hcmus.application.event.EventType;
import nxc.hcmus.application.event.PostEvent;
import nxc.hcmus.application.service.PostEventProcessService;
import nxc.hcmus.common.util.JsonUtil;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class PostProductConsumer {

    @Inject
    JsonUtil jsonUtil;

    @Inject
    Instance<PostEventProcessService> postEventProcessServices;

    private final Map<EventType, PostEventProcessService> eventProcessServiceMap = new HashMap<>();

    @PostConstruct
    void init() {
        System.out.println("PostProductConsumer init");
        postEventProcessServices.forEach(postEventProcessService -> {
            eventProcessServiceMap.put(postEventProcessService.getEventType(), postEventProcessService);
        });
    }

    @Incoming("product-request")
    @Blocking
    @Transactional
    public void postProductConsumer(String payload) {
        System.out.println("Received <" + payload + ">");
//        PostEvent event = jsonUtil.convertJsonToObject(payload, PostEvent.class);
//        System.out.println("Received <" + event + ">");
//
//        eventProcessServiceMap.get(event.getType())
//                .processEvent(event);
        PostEvent event = jsonUtil.convertJsonToObject(payload, PostEvent.class);
        eventProcessServiceMap.get(event.getType())
                .processEvent(event);
    }

}
