package com.bakery.services;

import com.bakery.exceptions.ServiceException;
import com.bakery.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers() throws ServiceException;
    User getUsertById(Long id) throws ServiceException;

    List<User> getUsersByRole(String role) throws ServiceException;
    User getUserByEmail(String email) throws ServiceException;
    User getUserByPhoneNumber(String phoneNumber) throws ServiceException;

    User saveUser(User user) throws ServiceException;
    User updateUser(User user) throws ServiceException;
    void deleteUser(User user) throws ServiceException;

}
