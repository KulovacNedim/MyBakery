package com.bakery.dao;

import com.bakery.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDAO extends JpaRepository<Address, Long> {
}
