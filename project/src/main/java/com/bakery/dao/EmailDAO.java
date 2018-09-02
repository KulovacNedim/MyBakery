package com.bakery.dao;

import com.bakery.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailDAO extends JpaRepository<Email, Long> {
}
