//package nxc.hcmus.controller.http.category;
//
//import lombok.RequiredArgsConstructor;
//import nxc.hcmus.application.service.category.CategoryAppService;
//import nxc.hcmus.application.model.category.CategoryRequest;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RequiredArgsConstructor
//@RestController
//@RequestMapping("/api/v1/categories")
//public class CategoryController {
//
//    private final CategoryAppService categoryAppService;
//
//    @PostMapping
//    public ResponseEntity<Void> createCategory(
//            @RequestBody CategoryRequest categoryRequest
//    ) {
//        categoryAppService.createCategory(categoryRequest);
//        return ResponseEntity.accepted().build();
//    }
//}
