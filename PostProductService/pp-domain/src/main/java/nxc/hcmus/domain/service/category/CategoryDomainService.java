package nxc.hcmus.domain.service.category;

import nxc.hcmus.domain.model.entity.category.Category;
import nxc.hcmus.domain.model.entity.category.CreateCategoryRequest;

public interface CategoryDomainService {
    CreateCategoryRequest createCategory(Category category);
}
