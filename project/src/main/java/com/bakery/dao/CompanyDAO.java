package com.bakery.dao;

import com.bakery.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyDAO extends JpaRepository<Company, Long> {

    Company findByIsActive(boolean isActive);
}
