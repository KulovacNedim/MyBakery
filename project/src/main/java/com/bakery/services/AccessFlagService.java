package com.bakery.services;

import com.bakery.exceptions.ServiceException;
import com.bakery.model.AccessFlag;

import java.util.List;

public interface AccessFlagService {

    List<AccessFlag> getAllAccessFlags() throws ServiceException;
    List<AccessFlag> getAccessFlagsByRole(String role) throws ServiceException;
    AccessFlag getAccessFlagByAccessFlag(String accessFlagg) throws ServiceException;
    AccessFlag getAccessFlagById(Long id) throws ServiceException;
    AccessFlag saveAccessFlag(AccessFlag accessFlag) throws ServiceException;
    AccessFlag updateAccessFlag(AccessFlag accessFlag) throws ServiceException;
    void deleteAccessFlag(AccessFlag accessFlag) throws ServiceException;
}
