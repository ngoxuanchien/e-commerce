package nxc.hcmus.application.service.deferresult;

import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;

public interface DeferredResultService {
    DeferredResult<ResponseEntity<?>> configDeferredResult();
    DeferredResult<ResponseEntity<?>> createDefaultDeferredResult();
    void setResult(String key, Object result);
    void save(String key, DeferredResult<?> deferredResult);
    void setOnTimeout(String key, Runnable onTimeout);
}
