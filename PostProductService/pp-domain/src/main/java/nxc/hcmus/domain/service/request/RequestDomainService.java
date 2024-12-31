package nxc.hcmus.domain.service.request;

import nxc.hcmus.domain.model.entity.AbstractRequest;

import java.util.UUID;

public interface RequestDomainService {
    AbstractRequest createRequest(AbstractRequest request);
    AbstractRequest requestAccepted(UUID requestId);
}
