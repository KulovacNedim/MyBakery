package com.bakery.dao;

import com.bakery.exceptions.ServiceException;
import com.bakery.model.Role;
import com.bakery.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

    User getUserByEmail(String email) throws ServiceException;
    User getUserByPhoneNumber(String phoneNumber) throws ServiceException;
    List<User> getUsersByRole(Role role) throws ServiceException;

}
