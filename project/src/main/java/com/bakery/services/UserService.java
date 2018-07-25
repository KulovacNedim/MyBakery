package com.bakery.services;

import com.bakery.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getUsertById(Long id);

    List<User> getUsersByRole(String role);
    User getUserByEmail(String email);
    User getUserByPhoneNumber(String phoneNumber);

    User saveUser(User user);
    User updateUser(User user);
    void deleteUser(User user);

}
