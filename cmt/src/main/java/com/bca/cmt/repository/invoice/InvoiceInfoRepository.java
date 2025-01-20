package com.bca.cmt.repository.invoice;

import com.bca.cmt.model.invoice.InvoiceInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceInfoRepository extends JpaRepository<InvoiceInfo, Long> {
}
