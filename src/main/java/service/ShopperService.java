package service;

import dto.ProductMetadataDTO;
import dto.ShopperListRequestDto;
import dto.ShopperProductDto;
import io.micrometer.common.util.StringUtils;
import models.Product;
import models.ShopperProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import repository.ProductRepository;
import repository.ShopperProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopperService {

    @Autowired
    private ShopperProductRepository shopperProductRepository;

    @Autowired
    private ProductRepository productRepository;

    public void saveShopperList(ShopperListRequestDto shopperListDto) {
        Long shopperId = shopperListDto.getShopperId();
        List<ShopperProductDto> products = shopperListDto.getShopperProducts();

        List<ShopperProduct> productList = products.stream()
                .map(productDto -> new ShopperProduct(shopperId, productDto.getProductId(), productDto.getRelevancyScore()))
                .collect(Collectors.toList());

        shopperProductRepository.saveAll(productList);
    }

    public List<ProductMetadataDTO> getShopperProductList(String shopperId, String category, String brand, String productId, int limit, int page, String sortBy, String sortOrder) {
        Specification<Product> spec = Specification.<Product>and()
                .eq("shopperId", shopperId)
                .eq(StringUtils.isNotBlank(category), "category", category)
                .eq(StringUtils.isNotBlank(brand), "brand", brand)
                .eq(StringUtils.isNotBlank(productId), "productId", productId)
                .build();

        Sort sort = Sort.by(Sort.Direction.fromString(sortOrder), sortBy);
        Pageable pageable = PageRequest.of(page, limit, sort);

        Page<Product> productPage = productRepository.findAll(spec, pageable);

        return productPage.getContent().stream().map(ProductMetadataDTO::fromEntity).collect(Collectors.toList());
    }


}
