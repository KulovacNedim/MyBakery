package com.bakery.dao;

import com.bakery.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneDAO extends JpaRepository<Phone, Long> {
}
