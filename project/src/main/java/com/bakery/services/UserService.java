package com.bakery.services;

import com.bakery.model.User;

import java.util.List;

public interface UserService {

    public User findUserByEmail(String email);
    public void saveUser(User user);

    //

    List<User> getAllUsers();
    User getUsertById(Long id);

    List<User> getUsersByRole(String role);
    User getUserByPhoneNumber(String phoneNumber);

    User updateUser(User user);
    void deleteUser(User user);

}
