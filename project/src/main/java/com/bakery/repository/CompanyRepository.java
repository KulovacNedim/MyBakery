package com.bakery.repository;

import com.bakery.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    Company findByIsActive(boolean isActive);
}
