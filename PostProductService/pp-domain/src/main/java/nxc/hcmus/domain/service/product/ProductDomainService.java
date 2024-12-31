package nxc.hcmus.domain.service.product;

import nxc.hcmus.domain.model.entity.product.CreateProductRequest;
import nxc.hcmus.domain.model.entity.product.Product;

public interface ProductDomainService {
    CreateProductRequest createProduct(Product newProduct);
}
