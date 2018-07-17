package com.bakery.dao;

import com.bakery.exceptions.ServiceException;
import com.bakery.model.AccessFlag;
import com.bakery.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccessFlagDAO extends JpaRepository<AccessFlag, Long> {

    AccessFlag getAccessFlagByAccessFlag(String accesFlag) throws ServiceException;
    List<AccessFlag> getAccessFlagsByRoles(Role role) throws ServiceException;

}
