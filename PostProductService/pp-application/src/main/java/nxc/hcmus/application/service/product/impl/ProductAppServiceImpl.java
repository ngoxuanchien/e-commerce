package nxc.hcmus.application.service.product.impl;

import lombok.RequiredArgsConstructor;
import nxc.hcmus.application.brokermq.rabbitmq.producer.PostProductProducer;
import nxc.hcmus.application.model.product.ProductRequest;
import nxc.hcmus.application.model.product.ProductResponse;
import nxc.hcmus.application.service.deferresult.DeferredResultService;
import nxc.hcmus.application.service.mapper.CategoryAppMapper;
import nxc.hcmus.application.service.mapper.ProductAppMapper;
import nxc.hcmus.application.service.mapper.RequestEventMapper;
import nxc.hcmus.application.service.product.ProductAppService;
import nxc.hcmus.domain.service.product.ProductDomainService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductAppServiceImpl implements ProductAppService {

    private final ProductDomainService productDomainService;
    private final DeferredResultService deferredResultService;
    private final ProductAppMapper productAppMapper;
    private final PostProductProducer postProductProducer;
    private final RequestEventMapper requestEventMapper;

    @Override
    public ProductResponse createProduct(ProductRequest request, DeferredResult<ResponseEntity<?>> deferredResult) {
        var newProduct = Optional.ofNullable(request)
                .map(productAppMapper::productRequestToProduct)
                .orElseThrow(() -> new RuntimeException("Product is null"));
        var createProductRequest = productDomainService.createProduct(newProduct);
        deferredResult.onTimeout(() -> {
            deferredResult.setResult(
                    ResponseEntity.accepted()
                            .body(createProductRequest)
            );
        });

        deferredResultService.save(createProductRequest.getRequestId().toString(), deferredResult);
        postProductProducer.sendPostRequest(requestEventMapper.requestToRequestEvent(createProductRequest));

        return productAppMapper.productToProductResponse(newProduct);
    }
}
