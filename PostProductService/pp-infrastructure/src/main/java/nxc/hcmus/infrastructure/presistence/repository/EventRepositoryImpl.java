package nxc.hcmus.infrastructure.presistence.repository;

import lombok.RequiredArgsConstructor;
import nxc.hcmus.domain.model.events.AbstractEvent;
import nxc.hcmus.domain.repository.EventRepository;
import nxc.hcmus.infrastructure.presistence.mapper.EventJpaRepositoryMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class EventRepositoryImpl implements EventRepository {

    private final EventJpaRepositoryMapper eventJpaRepositoryMapper;

    @Override
    public AbstractEvent saveEvent(AbstractEvent event) {
        return Optional.ofNullable(event)
//                .map(eventJpaRepositoryMapper::save)
                .orElseThrow(() -> new RuntimeException("Event is null"));
    }
}
