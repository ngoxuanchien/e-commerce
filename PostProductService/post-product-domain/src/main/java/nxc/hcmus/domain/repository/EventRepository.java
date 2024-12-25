package nxc.hcmus.domain.repository;

import nxc.hcmus.domain.model.events.AbstractEvent;

public interface EventRepository {
    AbstractEvent saveEvent(AbstractEvent event);
}
