package dto;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class ShopperProductDto {

    @NotNull
    private String productId;

    @NotNull
    private Double relevancyScore;
}
