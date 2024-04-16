package dto;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Data
public class ShopperListRequestDto {

    @NotNull
    private Long shopperId;

    @NotNull
    private List<ShopperProductDto> shopperProducts;
}
