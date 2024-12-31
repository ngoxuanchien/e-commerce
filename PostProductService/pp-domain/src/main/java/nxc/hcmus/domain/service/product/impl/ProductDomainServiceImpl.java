package nxc.hcmus.domain.service.product.impl;

import lombok.RequiredArgsConstructor;
import nxc.hcmus.domain.model.entity.product.CreateProductRequest;
import nxc.hcmus.domain.model.entity.product.Product;
import nxc.hcmus.domain.service.product.ProductDomainService;
import nxc.hcmus.domain.service.request.RequestDomainService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductDomainServiceImpl implements ProductDomainService {

    private final RequestDomainService requestDomainService;

    @Override
    public CreateProductRequest createProduct(Product newProduct) {
        CreateProductRequest request = new CreateProductRequest(newProduct);
        return (CreateProductRequest) requestDomainService.createRequest(request);
    }
}
