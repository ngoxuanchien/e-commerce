package nxc.hcmus.application.model.category;

import java.util.List;
import java.util.UUID;

public record CategoryResponse(
        UUID id,
        String name,
        String description,
        List<Long> productIds
) {
}
