package com.bakery.services;

import com.bakery.model.Role;
import com.bakery.repository.RoleRepository;
import com.bakery.repository.UserRepository;
import com.bakery.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        Role role = roleRepository.findByName("Client");
        System.out.println("save user method---------------------------------------------------------------------------------------------------");
//        System.out.println(role.toString());
//        user.setRole(role);
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User getUsertById(Long id) {
        return null;
    }

    @Override
    public List<User> getUsersByRole(String role) {
        return null;
    }

    @Override
    public User getUserByPhoneNumber(String phoneNumber) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println(userName=="" ? "User je NULLLLLLLL": "Nije ovo greskAAAAAAAAAAAAAAAAAAAAAAAAAAAAAa");
        System.out.println("-----" + userName.toString());

        User user = userRepository.findByEmail(userName);


        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println(user==null ? "User je NULLLLLLLL": "Nije ovo greskAAAAAAAAAAAAAAAAAAAAAAAAAAAAAa");
        System.out.println(user.toString());
        Set<Role> userRoles = new HashSet<>();
        Role role = user.getRole();
        userRoles.add(role);
        List<GrantedAuthority> authorities = getUserAuthority(userRoles);
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("authorities-----" + authorities.toString());

        return buildUserForAuthentication(user, authorities);
    }



    private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        for (Role role : userRoles) {
            roles.add(new SimpleGrantedAuthority(role.getName()));
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>(roles);
        return grantedAuthorities;
    }

    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {

        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("pass-----" + user.getPassword());
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("mail-----" + user.getEmail());
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), true, true, true, true, authorities);
    }
}
