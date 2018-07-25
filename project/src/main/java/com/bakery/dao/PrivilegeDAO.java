package com.bakery.dao;

import com.bakery.model.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeDAO extends JpaRepository<Privilege, Long> {

    Privilege getPrivilegeByName(String name);

}
