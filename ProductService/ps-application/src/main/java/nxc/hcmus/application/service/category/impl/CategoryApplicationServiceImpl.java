package nxc.hcmus.application.service.category.impl;

import lombok.RequiredArgsConstructor;
import nxc.hcmus.application.exception.CategoryNotFoundException;
import nxc.hcmus.application.model.dto.category.CategoryResponse;
import nxc.hcmus.application.service.category.CategoryApplicationService;
import nxc.hcmus.application.service.mapper.CategoryApplicationMapper;
import nxc.hcmus.domain.service.category.CategoryDomainService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryApplicationServiceImpl implements CategoryApplicationService {

    private final CategoryDomainService categoryDomainService;

    private final CategoryApplicationMapper categoryApplicationMapper;

    @Override
    public CategoryResponse getCategoryById(UUID id) {
        return Optional.ofNullable(id)
                .map(categoryDomainService::findById)
                .orElseThrow(() -> new RuntimeException("Category id is null"))
                .map(categoryApplicationMapper::categoryToCategoryResponse)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with id: " + id));
    }
}
