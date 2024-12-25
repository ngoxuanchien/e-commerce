package nxc.hcmus.domain.model.entity;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private UUID id;
    private String name;
    private String description;
    private Long availableQuantity;
    private BigDecimal price;
    private List<Category> categories;

}
