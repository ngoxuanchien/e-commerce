package nxc.hcmus.application.model.dto.category;

import java.util.UUID;

public record CategoryResponse(
        UUID id,
        String name,
        String description
) {
}
