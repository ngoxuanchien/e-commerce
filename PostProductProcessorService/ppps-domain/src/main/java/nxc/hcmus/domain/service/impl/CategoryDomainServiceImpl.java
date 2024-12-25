package nxc.hcmus.domain.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import nxc.hcmus.domain.model.entity.Category;
import nxc.hcmus.domain.repository.CategoryRepository;
import nxc.hcmus.domain.service.CategoryDomainService;

import java.util.Optional;

@ApplicationScoped
@RequiredArgsConstructor
public class CategoryDomainServiceImpl implements CategoryDomainService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category category) {
        return Optional.ofNullable(category)
                .map(categoryRepository::saveCategory)
                .orElseThrow(() -> new RuntimeException("Category is null"));
    }
}
