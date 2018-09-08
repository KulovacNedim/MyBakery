package com.bakery.repository;

import com.bakery.model.Capability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapabilityRepository extends JpaRepository<Capability, Long> {

    Capability getAccessFlagByName(String name);

}
