package com.bca.cmt.repository.company;

import com.bca.cmt.model.company.Companies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompaniesRepository extends JpaRepository<Companies, Long> {
}
