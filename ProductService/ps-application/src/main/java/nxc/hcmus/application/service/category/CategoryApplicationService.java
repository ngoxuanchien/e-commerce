package nxc.hcmus.application.service.category;

import nxc.hcmus.application.model.dto.category.CategoryResponse;

import java.util.UUID;

public interface CategoryApplicationService {
    CategoryResponse getCategoryById(UUID id);
}
