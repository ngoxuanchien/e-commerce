package nxc.hcmus.domain.repository;

import nxc.hcmus.domain.model.entity.AbstractRequest;

import java.util.UUID;

public interface RequestRepository {
    AbstractRequest save(AbstractRequest request);

    AbstractRequest findById( UUID uuid);
}
