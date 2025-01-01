package nxc.hcmus.infrastructure.presistence.mapper;

import nxc.hcmus.domain.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryJpaMapper extends JpaRepository<Category, UUID> {
}