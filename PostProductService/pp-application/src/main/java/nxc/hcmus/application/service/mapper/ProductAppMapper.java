package nxc.hcmus.application.service.mapper;

import nxc.hcmus.application.model.product.ProductRequest;
import nxc.hcmus.application.model.product.ProductResponse;
import nxc.hcmus.domain.model.entity.product.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductAppMapper {

    @Mapping(target = "id", ignore = true)
    Product productRequestToProduct(ProductRequest request);

    ProductResponse productToProductResponse(Product product);
}
