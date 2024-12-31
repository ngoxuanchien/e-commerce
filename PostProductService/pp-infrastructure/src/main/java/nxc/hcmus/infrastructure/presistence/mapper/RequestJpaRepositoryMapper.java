package nxc.hcmus.infrastructure.presistence.mapper;

import nxc.hcmus.domain.model.entity.AbstractRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RequestJpaRepositoryMapper extends JpaRepository<AbstractRequest, UUID> {
}
