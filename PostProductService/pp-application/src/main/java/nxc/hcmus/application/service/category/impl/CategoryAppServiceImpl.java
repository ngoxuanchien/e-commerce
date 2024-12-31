package nxc.hcmus.application.service.category.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nxc.hcmus.application.brokermq.rabbitmq.producer.PostProductProducer;
import nxc.hcmus.application.model.category.CategoryRequest;
import nxc.hcmus.application.model.category.CategoryResponse;
import nxc.hcmus.application.service.category.CategoryAppService;
import nxc.hcmus.application.service.deferresult.DeferredResultService;
import nxc.hcmus.application.service.mapper.CategoryAppMapper;
import nxc.hcmus.application.service.mapper.RequestEventMapper;
import nxc.hcmus.domain.service.category.CategoryDomainService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryAppServiceImpl implements CategoryAppService {

    private final CategoryDomainService categoryDomainService;
    private final CategoryAppMapper categoryAppMapper;

    private final PostProductProducer postProducer;
    private final DeferredResultService deferredResultService;
    private final RequestEventMapper requestEventMapper;

    @Override
    public CategoryResponse createCategory(CategoryRequest request, DeferredResult<ResponseEntity<?>> deferredResult) {
        log.info("Create category: {}", request);
        var category = Optional.ofNullable(request)
                .map(categoryAppMapper::categoryRequestToCategory)
                .orElseThrow(() -> new RuntimeException("Category request is null"));

        var createCategoryRequest = categoryDomainService.createCategory(category);
        deferredResult.onTimeout(() -> {
            log.info("Timeout create category: {}", request);
            deferredResult.setResult(
                    ResponseEntity.accepted()
                            .body(createCategoryRequest)
            );
        });

        deferredResultService.save(createCategoryRequest.getRequestId().toString(), deferredResult);
        postProducer.sendPostRequest(requestEventMapper.requestToRequestEvent(createCategoryRequest));

        return categoryAppMapper.categoryToCategoryResponse(category);
    }
}
