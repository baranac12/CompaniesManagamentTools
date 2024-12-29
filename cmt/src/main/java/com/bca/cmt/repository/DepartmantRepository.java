package com.bca.cmt.repository;

import com.bca.cmt.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmantRepository extends JpaRepository<Department, Long> {
    Department findByName(String name);
}
