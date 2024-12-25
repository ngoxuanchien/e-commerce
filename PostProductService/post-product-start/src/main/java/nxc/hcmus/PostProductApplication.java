package nxc.hcmus;

import nxc.hcmus.application.model.category.CategoryRequest;
import nxc.hcmus.application.service.category.CategoryAppService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PostProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostProductApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
            CategoryAppService categoryAppService
    ) {
        return args -> {
            categoryAppService.createCategory(new CategoryRequest("Category 1", "Description 1"));
        };
    }
}