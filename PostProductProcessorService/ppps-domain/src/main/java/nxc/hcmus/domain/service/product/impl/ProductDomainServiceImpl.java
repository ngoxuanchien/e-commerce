package nxc.hcmus.domain.service.product.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import nxc.hcmus.domain.model.entity.Product;
import nxc.hcmus.domain.repository.ProductRepository;
import nxc.hcmus.domain.service.product.ProductDomainService;

import java.util.Optional;

@ApplicationScoped
public class ProductDomainServiceImpl implements ProductDomainService {

    @Inject
    ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return Optional.ofNullable(product)
                .map(productRepository::save)
                .orElseThrow(() -> new RuntimeException("Product is null"));
    }
}
