package nxc.hcmus.application.service.deferresult;

import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;

public interface DeferredResultService {
    DeferredResult<ResponseEntity<?>> configDeferredResult(String key);
    void setResult(String key, Object result);
    void save(String key, DeferredResult<ResponseEntity<?>> deferredResult);
}
