package nxc.hcmus.infrastructure.presistence.repository;

import lombok.RequiredArgsConstructor;
import nxc.hcmus.domain.model.entity.AbstractRequest;
import nxc.hcmus.domain.repository.RequestRepository;
import nxc.hcmus.infrastructure.presistence.mapper.RequestJpaRepositoryMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class RequestRepositoryImpl implements RequestRepository {

    private final RequestJpaRepositoryMapper requestJpaRepositoryMapper;

    @Override
    public AbstractRequest save(AbstractRequest request) {
        return Optional.ofNullable(request)
                .map(requestJpaRepositoryMapper::save)
                .orElseThrow(() -> new RuntimeException("Request is null"));
    }

    @Override
    public AbstractRequest findById(UUID uuid) {
        return requestJpaRepositoryMapper.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Request not found"));
    }
}
