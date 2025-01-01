package nxc.hcmus.application.service.mapper;

import nxc.hcmus.application.model.dto.category.CategoryResponse;
import nxc.hcmus.domain.model.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryApplicationMapper {

    CategoryResponse categoryToCategoryResponse(Category category);
}
