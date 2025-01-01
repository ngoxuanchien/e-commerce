package nxc.hcmus.domain.repository;

import nxc.hcmus.domain.model.entity.Category;
import org.springframework.data.repository.Repository;

import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository {
    Optional<Category> findById(UUID id);
}
