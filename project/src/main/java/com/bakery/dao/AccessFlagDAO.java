package com.bakery.dao;

import com.bakery.dto.AccessFlag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessFlagDAO extends JpaRepository<AccessFlag, Long> {
}
