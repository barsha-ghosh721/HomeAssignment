
package controller;

import dto.ProductMetadataDTO;
import dto.ShopperListRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ShopperService;

import java.util.List;


@RestController
@RequestMapping("/api/shopper")
public class ShopperController {

    @Autowired
    private ShopperService shopperService;

    @PostMapping("/shopper/product-list")
    public ResponseEntity<String> receiveShopperProductList(@RequestBody ShopperListRequestDto shopperProductList) {
        shopperService.saveShopperList(shopperProductList);
        return ResponseEntity.ok("Shopper product list received and stored successfully.");
    }

    @GetMapping("/shopper/{shopperId}/product-list")
    public ResponseEntity<List<ProductMetadataDTO>> getShopperProductList(
            @PathVariable String shopperId,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String productId,
            @RequestParam(required = false, defaultValue = "10") int limit,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "relevancyScore") String sortBy,
            @RequestParam(required = false, defaultValue = "asc") String sortOrder) {

        List<ProductMetadataDTO> productList = shopperService.getShopperProductList(shopperId, category, brand, productId, limit, page, sortBy, sortOrder);

        return ResponseEntity.ok(productList);
    }


}
