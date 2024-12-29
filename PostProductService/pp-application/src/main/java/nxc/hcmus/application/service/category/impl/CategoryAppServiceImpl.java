package nxc.hcmus.application.service.category.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nxc.hcmus.application.brokermq.rabbitmq.producer.PostProductProducer;
import nxc.hcmus.application.model.category.CategoryRequest;
import nxc.hcmus.application.model.category.CategoryResponse;
import nxc.hcmus.application.service.category.CategoryAppService;
import nxc.hcmus.application.service.deferresult.DeferredResultService;
import nxc.hcmus.application.service.mapper.CategoryAppMapper;
import nxc.hcmus.application.service.mapper.PostEventMapper;
import nxc.hcmus.common.util.UuidGeneratorUtil;
import nxc.hcmus.domain.service.event.EventDomainService;
import nxc.hcmus.domain.model.events.category.CreateCategoryEvent;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryAppServiceImpl implements CategoryAppService {

    private final EventDomainService eventDomainService;
    private final CategoryAppMapper categoryAppMapper;

    private final PostProductProducer postProducer;
    private final PostEventMapper postEventMapper;
    private final UuidGeneratorUtil uuidGeneratorUtil;
    private final DeferredResultService deferredResultService;

    @Override
    public CategoryResponse createCategory(CategoryRequest request, DeferredResult<ResponseEntity<?>> deferredResult) {
        log.info("Create category: {}", request);
        final var requestId = uuidGeneratorUtil.generateUuid();
        var category = Optional.ofNullable(request)
                .map(categoryAppMapper::categoryRequestToCategory)
                .orElseThrow(() -> new RuntimeException("Category request is null"));

        var event = new CreateCategoryEvent(category);
        event.setRequestId(requestId);
        deferredResultService.save(requestId, deferredResult);
        Optional.of(event)
                .map(eventDomainService::createEvent)
                .map(postEventMapper::eventToPostEvent)
                .ifPresent(postProducer::sendPostProduct);

        // Todo: continue to implement the logic here
        return categoryAppMapper.categoryToCategoryResponse(category);
    }
}
