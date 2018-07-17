package com.bakery.dao;

import com.bakery.exceptions.ServiceException;
import com.bakery.model.AccessFlag;
import com.bakery.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDAO extends JpaRepository<Role, Long> {

    Role getRoleByRole(String role) throws ServiceException;
    List<Role> getRolesByAccessFlags(AccessFlag accessFlag) throws ServiceException;

}
