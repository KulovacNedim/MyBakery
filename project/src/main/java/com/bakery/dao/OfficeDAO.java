package com.bakery.dao;

import com.bakery.model.Office;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeDAO extends JpaRepository<Office, Long> {
}
