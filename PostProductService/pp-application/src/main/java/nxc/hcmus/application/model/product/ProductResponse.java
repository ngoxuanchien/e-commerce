package nxc.hcmus.application.model.product;

import java.util.List;
import java.util.UUID;

public record ProductResponse(
        UUID id,
        String name,
        String description,
        float price,
        List<UUID> categoryIds
) {
}
