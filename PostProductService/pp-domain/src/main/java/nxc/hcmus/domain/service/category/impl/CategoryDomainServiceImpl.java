package nxc.hcmus.domain.service.category.impl;

import lombok.RequiredArgsConstructor;
import nxc.hcmus.domain.model.entity.category.Category;
import nxc.hcmus.domain.model.entity.category.CreateCategoryRequest;
import nxc.hcmus.domain.service.category.CategoryDomainService;
import nxc.hcmus.domain.service.request.RequestDomainService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryDomainServiceImpl implements CategoryDomainService {

    private final RequestDomainService requestDomainService;

    @Override
    public CreateCategoryRequest createCategory(Category category) {
        var request = new CreateCategoryRequest(category);
        return (CreateCategoryRequest) requestDomainService.createRequest(request);
    }
}
