package dao;

import model.User;

public interface UserDAO {

    User getUserById(int id);
    User getUserByEmail(String email);
    User getUserByPhoneNumber(String phoneNumber);
    boolean addUser(User user);
    boolean deleteUser(User user);
    boolean updateUser(User user);

}
