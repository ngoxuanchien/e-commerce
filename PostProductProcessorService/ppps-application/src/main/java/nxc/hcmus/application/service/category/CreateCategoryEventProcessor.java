package nxc.hcmus.application.service.category;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import nxc.hcmus.application.brokermq.producer.PostProductProducer;
import nxc.hcmus.application.event.EventType;
import nxc.hcmus.application.event.PostEvent;
import nxc.hcmus.application.service.PostEventProcessService;
import nxc.hcmus.common.util.JsonUtil;
import nxc.hcmus.domain.model.entity.Category;
import nxc.hcmus.domain.service.CategoryDomainService;

@Slf4j
@ApplicationScoped
public class CreateCategoryEventProcessor implements PostEventProcessService {

    @Inject
    CategoryDomainService categoryDomainService;

    @Inject
    PostProductProducer postProductProducer;

    @Inject
    JsonUtil jsonUtil;

    @Override
    public void processEvent(PostEvent event) {
        log.info("Process create category event: {}", event);
        Category category = jsonUtil.convertToObject(event.getPayload(), Category.class);
        var newCategory = categoryDomainService.createCategory(category);
        postProductProducer.sendEvent(event.getRoutingKey(), jsonUtil.convertObjectToJson(newCategory));
    }

    @Override
    public EventType getEventType() {
        return EventType.CREATE_CATEGORY;
    }
}
