package nxc.hcmus.application.service.mapper;

import nxc.hcmus.application.model.event.PostRequestEvent;
import nxc.hcmus.domain.model.events.AbstractEvent;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostEventMapper {

    PostRequestEvent eventToPostEvent(AbstractEvent event);
}
