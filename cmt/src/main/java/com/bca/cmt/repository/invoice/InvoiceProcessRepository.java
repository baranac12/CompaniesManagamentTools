package com.bca.cmt.repository.invoice;

import com.bca.cmt.model.invoice.InvoiceProcess;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceProcessRepository extends JpaRepository<InvoiceProcess, Long> {
}
