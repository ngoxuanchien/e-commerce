package nxc.hcmus.controller.http.category;

import lombok.RequiredArgsConstructor;
import nxc.hcmus.application.model.dto.category.CategoryResponse;
import nxc.hcmus.application.service.category.CategoryApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryApplicationService categoryApplicationService;

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(categoryApplicationService.getCategoryById(id));
    }

}
