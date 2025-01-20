package com.bca.cmt.repository.product;

import com.bca.cmt.model.product.ProductStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductStockRepository  extends JpaRepository<ProductStock, Long> {
}
