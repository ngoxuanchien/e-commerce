package nxc.hcmus.infrastructure.presistence.repository;

import lombok.RequiredArgsConstructor;
import nxc.hcmus.domain.model.entity.Category;
import nxc.hcmus.domain.repository.CategoryRepository;
import nxc.hcmus.infrastructure.presistence.mapper.CategoryJpaMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CategoryInfraRepositoryImpl implements CategoryRepository {

    private final CategoryJpaMapper categoryJpaMapper;

    @Override
    public Optional<Category> findById(UUID id) {
        return Optional.ofNullable(id)
                .map(categoryJpaMapper::findById)
                .orElseThrow(() -> new RuntimeException("Category id is null"));
    }
}
