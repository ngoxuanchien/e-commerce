package nxc.hcmus.infrastructure.persitence.mapper;

import jakarta.enterprise.context.ApplicationScoped;
import nxc.hcmus.domain.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryJpaMapper extends JpaRepository<Category, Long> {
}
