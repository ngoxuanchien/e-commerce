package nxc.hcmus.application.model.category;

import java.util.List;

public record CategoryResponse(
        Long id,
        String name,
        String description,
        List<Long> productIds
) {
}
