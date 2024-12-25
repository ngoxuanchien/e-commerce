package nxc.hcmus.domain.service;

import nxc.hcmus.domain.model.events.AbstractEvent;

public interface EventDomainService {
    AbstractEvent createEvent(AbstractEvent event);
}
