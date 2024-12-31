package nxc.hcmus.application.service.mapper;

import nxc.hcmus.application.model.event.RequestEvent;
import nxc.hcmus.domain.model.entity.AbstractRequest;
import nxc.hcmus.domain.model.entity.category.CreateCategoryRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface RequestEventMapper {


    @Mapping(target = "responseQueue", ignore = true)
    RequestEvent requestToRequestEvent(AbstractRequest request);
}
