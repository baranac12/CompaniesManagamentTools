package com.bca.cmt.repository;

import com.bca.cmt.model.ProductStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductStockRepository  extends JpaRepository<ProductStock, Long> {
}
