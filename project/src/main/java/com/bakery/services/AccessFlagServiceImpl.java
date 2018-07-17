package com.bakery.services;

import com.bakery.dao.AccessFlagDAO;
import com.bakery.exceptions.ErrorCode;
import com.bakery.exceptions.ServiceException;
import com.bakery.model.AccessFlag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessFlagServiceImpl implements AccessFlagService {

    @Autowired
    private AccessFlagDAO accessFlagDAO;

    @Autowired
    private RoleService roleService;

    @Override
    public List<AccessFlag> getAllAccessFlags() throws ServiceException {
        try {
            return accessFlagDAO.findAll();
        } catch (Exception e) {
            throw new ServiceException(e, ErrorCode.GET_ACCESS_FLAG_ERROR);
        }
    }

    @Override
    public List<AccessFlag> getAccessFlagsByRole(String role) throws ServiceException {
        try {
            return accessFlagDAO.getAccessFlagByRoles(roleService.getRoleByRoleName(role));
        } catch (Exception e) {
            throw new ServiceException(e, ErrorCode.GET_ACCESS_FLAG_ERROR);
        }
    }

    @Override
    public AccessFlag getAccessFlagByAccessFlag(String accessFlagg) throws ServiceException {
        try {
            return accessFlagDAO.getAccessFlagByAccessFlag(accessFlagg);
        } catch (Exception e) {
            throw new ServiceException(e, ErrorCode.ACCESS_FLAG_NOT_FOUND);
        }
    }

    @Override
    public AccessFlag getAccessFlagById(Long id) throws ServiceException {
        try {
            return accessFlagDAO.findById(id).get();
        } catch (Exception e) {
            throw new ServiceException(e, ErrorCode.ACCESS_FLAG_NOT_FOUND);
        }
    }

    @Override
    public AccessFlag saveAccessFlag(AccessFlag accessFlag) throws ServiceException {
        try {
            return accessFlagDAO.save(accessFlag);
        } catch (Exception e) {
            throw new ServiceException(e, ErrorCode.SAVE_ACCESS_FLAG_ERROR);
        }
    }

    @Override
    public AccessFlag updateAccessFlag(AccessFlag accessFlag) throws ServiceException {
        try {
            return accessFlagDAO.save(accessFlag);
        } catch (Exception e) {
            throw new ServiceException(e, ErrorCode.UPDATE_ACCESS_FLAG_ERROR);
        }
    }

    @Override
    public void deleteAccessFlag(AccessFlag accessFlag) throws ServiceException {
        try {
            accessFlagDAO.delete(accessFlag);
        } catch (Exception e) {
            throw new ServiceException(e, ErrorCode.DELETE_ACCESS_FLAG_ERROR);
        }
    }
}
