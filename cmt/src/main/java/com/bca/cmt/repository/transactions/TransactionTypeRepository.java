package com.bca.cmt.repository.transactions;

import com.bca.cmt.model.transactions.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionTypeRepository extends JpaRepository<TransactionType, Long> {
}
