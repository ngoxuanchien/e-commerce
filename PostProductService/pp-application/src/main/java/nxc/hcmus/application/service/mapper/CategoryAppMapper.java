package nxc.hcmus.application.service.mapper;

import nxc.hcmus.application.model.category.CategoryRequest;
import nxc.hcmus.application.model.category.CategoryResponse;
import nxc.hcmus.domain.model.entity.category.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.lang.annotation.Target;

@Mapper(componentModel = "spring")
public interface CategoryAppMapper {

    @Mapping(target = "id", ignore = true)
    Category categoryRequestToCategory(CategoryRequest request);

    CategoryResponse categoryToCategoryResponse(Category category);


}
