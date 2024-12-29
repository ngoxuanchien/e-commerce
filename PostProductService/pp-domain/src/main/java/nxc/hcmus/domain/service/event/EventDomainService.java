package nxc.hcmus.domain.service.event;

import nxc.hcmus.domain.model.events.AbstractEvent;

public interface EventDomainService {
    AbstractEvent createEvent(AbstractEvent event);
}
