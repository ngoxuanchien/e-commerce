package nxc.hcmus.application.service.deferresult.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nxc.hcmus.application.service.deferresult.DeferredResultService;
import nxc.hcmus.domain.repository.InMemoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class DeferredResultServiceImpl implements DeferredResultService {

    @SuppressWarnings("rawtypes")
    private final InMemoryRepository<DeferredResult> deferredResultInMemoryRepository;


    @Override
    public DeferredResult<ResponseEntity<?>> configDeferredResult(String key) {
        DeferredResult<ResponseEntity<?>> deferredResult = new DeferredResult<>(5000L);

        deferredResult.onTimeout(() -> {
            deferredResult.setResult(ResponseEntity.accepted().build());
        });

        return deferredResult;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void setResult(String key, Object result) {
        Optional.ofNullable(deferredResultInMemoryRepository.get(key))
                .ifPresent(deferredResult -> {
                    deferredResultInMemoryRepository.remove(key);
                    deferredResult.setResult(result);
                });
    }

    @Override
    public void save(String key, DeferredResult<ResponseEntity<?>> deferredResult) {
        deferredResultInMemoryRepository.put(key, deferredResult);
    }
}
