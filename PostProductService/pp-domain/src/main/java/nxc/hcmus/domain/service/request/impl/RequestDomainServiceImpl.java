package nxc.hcmus.domain.service.request.impl;

import lombok.RequiredArgsConstructor;
import nxc.hcmus.domain.model.entity.AbstractRequest;
import nxc.hcmus.domain.model.entity.product.CreateProductRequest;
import nxc.hcmus.domain.repository.RequestRepository;
import nxc.hcmus.domain.service.request.RequestDomainService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RequestDomainServiceImpl implements RequestDomainService {

    private final RequestRepository requestRepository;

    @Override
    public AbstractRequest createRequest(AbstractRequest request) {
        return Optional.ofNullable(request)
                .map(requestRepository::save)
                .orElseThrow(() -> new RuntimeException("Request is null"));
    }

    @Override
    public AbstractRequest requestAccepted(UUID requestId) {
        return Optional.ofNullable(requestId)
                .map(requestRepository::findById)
                .map(AbstractRequest::accepted)
                .map(requestRepository::save)
                .orElseThrow(() -> new RuntimeException("Request not found"));
    }
}
