package nxc.hcmus.application.service.category;

import nxc.hcmus.application.model.category.CategoryRequest;
import nxc.hcmus.application.model.category.CategoryResponse;

public interface CategoryAppService {
    CategoryResponse createCategory(CategoryRequest request);
}
