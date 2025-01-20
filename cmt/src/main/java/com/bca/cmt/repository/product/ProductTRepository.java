package com.bca.cmt.repository.product;

import com.bca.cmt.model.transactions.ProductT;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTRepository extends JpaRepository<ProductT, Long> {
}
