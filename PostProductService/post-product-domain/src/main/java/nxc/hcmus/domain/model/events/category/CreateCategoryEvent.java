package nxc.hcmus.domain.model.events.category;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import nxc.hcmus.domain.model.events.AbstractEvent;
import nxc.hcmus.domain.model.entity.Category;
import nxc.hcmus.domain.model.enums.EventType;

@NoArgsConstructor
@Entity
public class CreateCategoryEvent extends AbstractEvent {
    public CreateCategoryEvent(
            final Category payload
    ) {
        super(null, EventType.CREATE_CATEGORY, payload);
    }
}
