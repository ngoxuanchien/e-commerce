package nxc.hcmus.domain.model.entity.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import lombok.NoArgsConstructor;
import nxc.hcmus.domain.model.entity.AbstractRequest;
import nxc.hcmus.domain.model.enums.RequestType;

@Entity
@NoArgsConstructor
public class CreateProductRequest extends AbstractRequest {

    public CreateProductRequest(
            final Product payload
    ) {
        super(RequestType.CREATE_PRODUCT, payload);
    }
}
