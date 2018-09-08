package com.bakery.repository;

import com.bakery.model.Role;
import com.bakery.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    User findByFirstName(String fn);

    //

    User getUserByPhoneNumber(String phoneNumber);

    List<User> getUsersByRole(Role role);

}
