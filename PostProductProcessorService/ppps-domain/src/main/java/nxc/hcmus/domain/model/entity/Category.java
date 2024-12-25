package nxc.hcmus.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_id_seq")
    @SequenceGenerator(name = "category_id_seq", sequenceName = "category_id_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String description;
//    private List<Product> products;
}
