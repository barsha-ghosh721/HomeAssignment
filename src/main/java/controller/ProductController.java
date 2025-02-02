package controller;

import dto.ProductMetaDataRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ProductService;


@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product/metadata")
    public ResponseEntity<String> saveProductMetadata(@RequestBody ProductMetaDataRequestDTO productMetadata) {
        productService.storeProductMetadata(productMetadata);
        return ResponseEntity.ok("Product metadata received and stored successfully.");
    }
}
