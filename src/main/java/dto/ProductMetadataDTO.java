package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import models.Brand;
import models.Category;
import models.Product;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductMetadataDTO {
    private String productId;
    private Category category;
    private Brand brand;
    private Double relevancyScore;

    public static ProductMetadataDTO fromEntity(Product product) {
        ProductMetadataDTO dto = new ProductMetadataDTO();
        dto.setProductId(product.getProductId());
        dto.setCategory(product.getCategory());
        dto.setBrand(product.getBrand());
        dto.setRelevancyScore(product.getRelevancyScore());
        return dto;
    }
}

