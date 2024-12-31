package nxc.hcmus.application.brokermq.consumer;

import io.smallrye.common.annotation.RunOnVirtualThread;
import io.smallrye.reactive.messaging.annotations.Blocking;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import nxc.hcmus.application.event.EventType;
import nxc.hcmus.application.event.PostEvent;
import nxc.hcmus.application.service.PostEventProcessService;
import nxc.hcmus.common.util.JsonUtil;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ApplicationScoped
public class PostProductConsumer {

    @Inject
    JsonUtil jsonUtil;

    @Inject
    Instance<PostEventProcessService> postEventProcessServices;

    private final Map<EventType, PostEventProcessService> eventProcessServiceMap = new HashMap<>();

    @PostConstruct
    void init() {
        log.info("Init PostProductConsumer");
        postEventProcessServices.forEach(postEventProcessService -> {
            eventProcessServiceMap.put(postEventProcessService.getEventType(), postEventProcessService);
        });
    }

    @Incoming("product-request")
    @Blocking
    @Transactional
    @RunOnVirtualThread
    public void postProductConsumer(String payload) {
        System.out.println("Received <" + payload + ">");
        System.out.println(Thread.currentThread());
        PostEvent event = jsonUtil.convertJsonToObject(payload, PostEvent.class);
        eventProcessServiceMap.get(event.getType())
                .processEvent(event);
    }

}
