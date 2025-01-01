package nxc.hcmus.domain.service.category;

import nxc.hcmus.domain.model.entity.Category;
import nxc.hcmus.domain.repository.CategoryRepository;

import java.util.Optional;
import java.util.UUID;

public interface CategoryDomainService {

    Optional<Category> findById(UUID id);
}
