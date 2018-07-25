package com.bakery.services;

import com.bakery.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> getAllRoles();

    Role getRoleById(Long id);

    Role getRoleByRoleName(String roleName);

    Role updateRole(Role role);

    Role saveRole(Role role);

    void deleteRole(Role role);

}
