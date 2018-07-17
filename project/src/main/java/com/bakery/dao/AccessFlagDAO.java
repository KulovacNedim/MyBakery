package com.bakery.dao;

import com.bakery.model.AccessFlag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccessFlagDAO extends JpaRepository<AccessFlag, Long> {
}
