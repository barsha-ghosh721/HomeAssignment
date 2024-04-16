package repository;

import models.ShopperProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopperProductRepository extends JpaRepository<ShopperProduct, String> {
}
