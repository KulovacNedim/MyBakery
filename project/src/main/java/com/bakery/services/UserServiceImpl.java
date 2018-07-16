package com.bakery.services;

import com.bakery.dao.UserDAO;
import com.bakery.exceptions.ErrorCode;
import com.bakery.exceptions.ServiceException;
import com.bakery.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> getAllUsers() throws ServiceException {
        try {
            return userDAO.findAll();
        }
        catch (Exception e) {
            throw new ServiceException(e, ErrorCode.GET_USER_ERROR);
        }
    }

    @Override
    public User getUsertById(Long id) throws ServiceException {
        try {
            return userDAO.findById(id).get();
        } catch (Exception e) {
            throw new ServiceException(e, ErrorCode.USER_NOT_FOUND);
        }
    }

    @Override
    public User getUserByEmail(String email) throws ServiceException {
        try {
            return userDAO.getUserByEmail(email);
        } catch (Exception e) {
            throw new ServiceException(e, ErrorCode.USER_NOT_FOUND);
        }
    }

    @Override
    public User getUserByPhoneNumber(String phoneNumber) throws ServiceException {
        try {
            return userDAO.getUserByPhoneNumber(phoneNumber);
        } catch (Exception e) {
            throw new ServiceException(e, ErrorCode.USER_NOT_FOUND);
        }
    }

    @Override
    public User saveUser(User user) throws ServiceException {
        try {
            return userDAO.save(user);
        } catch (Exception e) {
            throw new ServiceException(e, ErrorCode.SAVE_USER_ERROR);
        }
    }

    @Override
    public User updateUser(User user) throws ServiceException {
        try {
            return userDAO.save(user);
        } catch (Exception e) {
            throw new ServiceException(e, ErrorCode.UPDATE_USER_ERROR);
        }
    }

    @Override
    public void deleteUser(User user) throws ServiceException {
        try {
            userDAO.delete(user);
        } catch (Exception e) {
            throw new ServiceException(e, ErrorCode.DELETE_USER_ERROR);
        }
    }
}
