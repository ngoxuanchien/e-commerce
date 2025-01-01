package nxc.hcmus.domain.service.category.impl;

import lombok.RequiredArgsConstructor;
import nxc.hcmus.domain.model.entity.Category;
import nxc.hcmus.domain.repository.CategoryRepository;
import nxc.hcmus.domain.service.category.CategoryDomainService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryDomainServiceImpl implements CategoryDomainService {

    private final CategoryRepository categoryRepository;

    @Override
    public Optional<Category> findById(UUID id) {
        return Optional.ofNullable(id)
                .map(categoryRepository::findById)
                .orElseThrow(() -> new RuntimeException("Category id is null"));
    }
}
