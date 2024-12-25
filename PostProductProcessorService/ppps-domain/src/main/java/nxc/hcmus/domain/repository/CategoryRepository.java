package nxc.hcmus.domain.repository;

import nxc.hcmus.domain.model.entity.Category;

public interface CategoryRepository {
    Category saveCategory(Category category);
}
