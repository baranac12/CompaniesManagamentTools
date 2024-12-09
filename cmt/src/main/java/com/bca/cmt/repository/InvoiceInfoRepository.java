package com.bca.cmt.repository;

import com.bca.cmt.model.InvoiceInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceInfoRepository extends JpaRepository<InvoiceInfo, Long> {
}
