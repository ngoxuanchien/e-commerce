package nxc.hcmus.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product:post")
public class PostProductController {

    @PostMapping
    public ResponseEntity<String> postProduct() {
        return ResponseEntity.ok("Post product successfully");
    }
}
