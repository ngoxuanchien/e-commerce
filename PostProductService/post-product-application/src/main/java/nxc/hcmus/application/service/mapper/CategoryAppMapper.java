package nxc.hcmus.application.service.mapper;

import nxc.hcmus.application.model.category.CategoryRequest;
import nxc.hcmus.application.model.category.CategoryResponse;
import nxc.hcmus.domain.model.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryAppMapper {

    Category categoryRequestToCategory(CategoryRequest request);

    CategoryResponse categoryToCategoryResponse(Category category);
}
