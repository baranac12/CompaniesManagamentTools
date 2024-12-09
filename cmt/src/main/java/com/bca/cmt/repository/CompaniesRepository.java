package com.bca.cmt.repository;

import com.bca.cmt.model.Companies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompaniesRepository extends JpaRepository<Companies, Long> {
}
