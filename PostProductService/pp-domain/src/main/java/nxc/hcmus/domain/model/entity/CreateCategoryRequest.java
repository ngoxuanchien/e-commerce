package nxc.hcmus.domain.model.entity;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import nxc.hcmus.domain.model.enums.RequestStatus;
import nxc.hcmus.domain.model.enums.RequestType;

@Entity
@NoArgsConstructor
public class CreateCategoryRequest extends AbstractRequest {

    public CreateCategoryRequest(
            final Category payload
    ) {
        super(RequestType.CREATE_CATEGORY, payload);
    }
}
