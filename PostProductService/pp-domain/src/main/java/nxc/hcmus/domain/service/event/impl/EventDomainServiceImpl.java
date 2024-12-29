package nxc.hcmus.domain.service.event.impl;

import lombok.RequiredArgsConstructor;
import nxc.hcmus.domain.annotation.Domain;
import nxc.hcmus.domain.repository.EventRepository;
import nxc.hcmus.domain.service.event.EventDomainService;
import nxc.hcmus.domain.model.events.AbstractEvent;

import java.util.Optional;

@Domain
@RequiredArgsConstructor
public class EventDomainServiceImpl implements EventDomainService {

    private final EventRepository eventRepository;

    @Override
    public AbstractEvent createEvent(AbstractEvent event) {
        return Optional.ofNullable(event)
                .map(eventRepository::saveEvent)
                .orElseThrow(() -> new RuntimeException("Event is null"));
    }
}
