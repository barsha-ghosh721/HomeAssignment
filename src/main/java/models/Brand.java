package models;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "brand")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand_name", unique = true)
    private String brandName;

    // Other fields and constructors

}
