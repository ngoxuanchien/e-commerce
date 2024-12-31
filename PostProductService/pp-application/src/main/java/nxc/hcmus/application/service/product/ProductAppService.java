package nxc.hcmus.application.service.product;

import nxc.hcmus.application.model.product.ProductRequest;
import nxc.hcmus.application.model.product.ProductResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;

public interface ProductAppService {
    ProductResponse createProduct(ProductRequest request, DeferredResult<ResponseEntity<?>> deferredResult);
}
