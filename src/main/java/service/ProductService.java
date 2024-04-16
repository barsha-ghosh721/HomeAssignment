package service;


import dto.ProductMetaDataRequestDTO;
import models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void storeProductMetadata(ProductMetaDataRequestDTO productMetadataRequest) {
        List<Product> productMetadataList = productMetadataRequest.getProductMetadataList().stream()
                .map(metadata -> Product.builder()
                        .productId(metadata.getProductId())
                        .category(metadata.getCategory())
                        .brand(metadata.getBrand())
                        .build())
                .collect(Collectors.toList());
        productRepository.saveAll(productMetadataList);
    }
}
