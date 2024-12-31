package nxc.hcmus.domain.repository;

import nxc.hcmus.domain.model.entity.Product;

public interface ProductRepository {
    Product save(Product product);
}
