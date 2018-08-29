package com.bakery.dao;

import com.bakery.model.Capability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapabilityDAO extends JpaRepository<Capability, Long> {

    Capability getAccessFlagByCapabilityName(String capabilityName);

}
