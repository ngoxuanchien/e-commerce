package nxc.hcmus.domain.model.events.product;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import nxc.hcmus.domain.model.events.AbstractEvent;
import nxc.hcmus.domain.model.entity.Product;
import nxc.hcmus.domain.model.enums.EventType;

@Entity
@NoArgsConstructor
public class CreateProductEvent extends AbstractEvent {

    public CreateProductEvent(
            final Product payload
    ) {
        super(null, EventType.CREATE_PRODUCT, payload);
    }
}
