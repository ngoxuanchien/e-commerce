package nxc.hcmus.application.service.category;

import nxc.hcmus.application.model.category.CategoryRequest;
import nxc.hcmus.application.model.category.CategoryResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;

public interface CategoryAppService {
    CategoryResponse createCategory(CategoryRequest request, DeferredResult<ResponseEntity<?>> deferredResult);
}
