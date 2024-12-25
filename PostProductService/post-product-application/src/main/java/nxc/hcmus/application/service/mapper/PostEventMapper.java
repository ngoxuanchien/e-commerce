package nxc.hcmus.application.service.mapper;

import nxc.hcmus.application.model.event.PostEvent;
import nxc.hcmus.domain.model.events.AbstractEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostEventMapper {

    PostEvent eventToPostEvent(AbstractEvent event);
}
