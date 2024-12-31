package nxc.hcmus.application.model.product;

import java.util.List;
import java.util.UUID;

public record ProductRequest(
        String name,
        String description,
        float price,
        List<UUID> categoryIds
) {
}
