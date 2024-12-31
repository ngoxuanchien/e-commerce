package nxc.hcmus.infrastructure.persitence.repository;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import nxc.hcmus.domain.model.entity.Product;
import nxc.hcmus.domain.repository.ProductRepository;
import nxc.hcmus.infrastructure.persitence.mapper.ProductJpaMapper;

import java.util.Optional;

@RequiredArgsConstructor
@ApplicationScoped
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductJpaMapper productJpaMapper;

    @Override
    public Product save(Product product) {
        return Optional.ofNullable(product)
                .map(productJpaMapper::save)
                .orElseThrow(() -> new RuntimeException("Product is null"));
    }
}
