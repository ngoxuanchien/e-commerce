package nxc.hcmus.application.service.category.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nxc.hcmus.application.brokermq.rabbitmq.producer.PostProductProducer;
import nxc.hcmus.application.model.category.CategoryRequest;
import nxc.hcmus.application.model.category.CategoryResponse;
import nxc.hcmus.application.service.category.CategoryAppService;
import nxc.hcmus.application.service.mapper.CategoryAppMapper;
import nxc.hcmus.application.service.mapper.PostEventMapper;
import nxc.hcmus.domain.service.EventDomainService;
import nxc.hcmus.domain.model.events.category.CreateCategoryEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryAppServiceImpl implements CategoryAppService {

    private final EventDomainService eventDomainService;
    private final CategoryAppMapper categoryAppMapper;

    private final PostProductProducer postProducer;
    private final PostEventMapper postEventMapper;

    @Override
    public CategoryResponse createCategory(CategoryRequest request) {
        log.info("Create category: {}", request);
        var category = Optional.ofNullable(request)
                .map(categoryAppMapper::categoryRequestToCategory)
                .orElseThrow(() -> new RuntimeException("Category request is null"));

        var event = new CreateCategoryEvent(category);
        Optional.of(event)
                .map(eventDomainService::createEvent)
                .map(postEventMapper::eventToPostEvent)
                .ifPresent(postProducer::sendPostProduct);

        // Todo: continue to implement the logic here
        return categoryAppMapper.categoryToCategoryResponse(category);
    }
}
