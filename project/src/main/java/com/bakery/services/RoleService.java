package com.bakery.services;

import com.bakery.exceptions.ServiceException;
import com.bakery.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> getAllRoles() throws ServiceException;
    Role getRoleById(Long id) throws ServiceException;

    Role getRoleByRoleName(String roleName) throws ServiceException;

    Role updateRole(Role role) throws ServiceException;
    Role saveRole(Role role) throws ServiceException;
    void deleteRole(Role role) throws ServiceException;

}
