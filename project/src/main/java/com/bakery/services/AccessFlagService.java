package com.bakery.services;

import com.bakery.exceptions.ServiceException;
import com.bakery.model.AccessFlag;

import java.util.List;

public interface AccessFlagService {

    List<AccessFlag> getAllAccesFlags() throws ServiceException;
    List<AccessFlag> getAccesFlagsByRole(String role) throws ServiceException;
    AccessFlag getAccessFlagByAccessFlag(String accessFlagg) throws ServiceException;
    AccessFlag getAccessFlagById(Long id) throws ServiceException;
    AccessFlag saveAccessFlag(AccessFlag accessFlag) throws ServiceException;
    AccessFlag updateAccesFlag(AccessFlag accessFlag) throws ServiceException;

}
