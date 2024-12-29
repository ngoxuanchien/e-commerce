package nxc.hcmus.controller.http.category;

import lombok.RequiredArgsConstructor;
import nxc.hcmus.application.model.category.CategoryResponse;
import nxc.hcmus.application.service.category.CategoryAppService;
import nxc.hcmus.application.model.category.CategoryRequest;
import nxc.hcmus.application.service.deferresult.DeferredResultService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryAppService categoryAppService;
    private final DeferredResultService deferredResultService;

    // Todo: Implement validate request
    @PostMapping
    public DeferredResult<ResponseEntity<?>> createCategory(
            @RequestBody CategoryRequest categoryRequest
    ) {
        var requestId = UUID.randomUUID().toString();
        DeferredResult<ResponseEntity<?>> deferredResult = deferredResultService.configDeferredResult(requestId);
        categoryAppService.createCategory(categoryRequest, deferredResult);
        return deferredResult;
    }

}
