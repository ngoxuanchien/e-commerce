package nxc.hcmus.infrastructure.presistence.mapper;

import nxc.hcmus.domain.model.events.AbstractEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventJpaRepositoryMapper extends JpaRepository<AbstractEvent, Long> {
}
