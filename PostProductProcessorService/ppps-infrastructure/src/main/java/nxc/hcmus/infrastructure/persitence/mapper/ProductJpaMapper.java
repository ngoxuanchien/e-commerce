package nxc.hcmus.infrastructure.persitence.mapper;

import nxc.hcmus.domain.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductJpaMapper extends JpaRepository<Product, UUID> {
}
