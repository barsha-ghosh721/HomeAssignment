package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ShopperProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productId;
    private Double relevancyScore;

    @ManyToOne
    @JoinColumn(name = "shopper_id")
    private Shopper shopper;


    public ShopperProduct(Long shopperId, String productId, Double relevancyScore) {
    }
}
