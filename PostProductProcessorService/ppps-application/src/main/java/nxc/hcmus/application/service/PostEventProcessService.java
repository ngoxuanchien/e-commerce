package nxc.hcmus.application.service;

import nxc.hcmus.application.event.EventType;
import nxc.hcmus.application.event.PostEvent;

public interface PostEventProcessService {
    void processEvent(PostEvent event);
    EventType getEventType();
}
