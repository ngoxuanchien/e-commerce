package nxc.hcmus.infrastructure.persitence.repository;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import nxc.hcmus.domain.model.entity.Category;
import nxc.hcmus.domain.repository.CategoryRepository;
import nxc.hcmus.infrastructure.persitence.mapper.CategoryJpaMapper;

import java.util.Optional;

@RequiredArgsConstructor
@ApplicationScoped
public class CategoryRepositoryImpl implements CategoryRepository {


    private final CategoryJpaMapper categoryJpaMapper;

    @Override
    public Category saveCategory(Category category) {
        return Optional.ofNullable(category)
                .map(categoryJpaMapper::save)
                .orElseThrow(() -> new RuntimeException("Category is null"));
    }
}
