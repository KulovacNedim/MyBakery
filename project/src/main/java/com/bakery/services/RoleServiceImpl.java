package com.bakery.services;

import com.bakery.dao.RoleDAO;
import com.bakery.exceptions.ErrorCode;
import com.bakery.exceptions.ServiceException;
import com.bakery.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDAO roleDAO;

    @Override
    public List<Role> getAllRoles() throws ServiceException {
        try {
            return roleDAO.findAll();
        } catch (Exception e) {
            throw new ServiceException(e, ErrorCode.GET_ROLE_ERROR);
        }
    }

    @Override
    public Role getRoleById(Long id) throws ServiceException {
        try {
            return roleDAO.findById(id).get();
        } catch (Exception e) {
            throw new ServiceException(e, ErrorCode.ROLE_NOT_FOUND);
        }
    }

    @Override
    public Role getRoleByRoleName(String roleName) throws ServiceException {
        try {
            return roleDAO.getRoleByRole(roleName);
        } catch (Exception e) {
            throw new ServiceException(e, ErrorCode.ROLE_NOT_FOUND);
        }
    }

    @Override
    public Role updateRole(Role role) throws ServiceException {
        try {
            return roleDAO.save(role);
        } catch (Exception e) {
            throw new ServiceException(e, ErrorCode.UPDATE_ROLE_ERROR);
        }
    }

    @Override
    public Role saveRole(Role role) throws ServiceException {
        try {
            return roleDAO.save(role);
        } catch (Exception e) {
            throw new ServiceException(e, ErrorCode.SAVE_ROLE_ERROR);
        }
    }

    @Override
    public void deleteRole(Role role) throws ServiceException {
        try {
            roleDAO.delete(role);
        } catch (Exception e) {
            throw new ServiceException(e, ErrorCode.DELETE_ROLE_ERROR);
        }
    }
}
