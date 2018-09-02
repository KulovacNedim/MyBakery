package com.bakery.dao;

import com.bakery.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDAO extends JpaRepository<Role, Long> {

    Role getRoleByName(String name);

}
