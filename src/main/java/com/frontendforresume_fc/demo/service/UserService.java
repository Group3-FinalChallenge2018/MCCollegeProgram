package com.frontendforresume_fc.demo.service;

import com.frontendforresume_fc.demo.model.Role;
import com.frontendforresume_fc.demo.model.User;
import com.frontendforresume_fc.demo.repository.RoleRepository;
import com.frontendforresume_fc.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public void saveNewUser(User user) {
        HashSet<Role> hash = new HashSet<>();
        hash.add(roleRepository.findByRole("USER"));
        user.setRoles(hash);
        userRepository.save(user);
    }

    public void saveNewAdmin(User user) {
        HashSet<Role> hash = new HashSet<>();
        hash.add(roleRepository.findByRole("ADMIN"));
        user.setRoles(hash);
        userRepository.save(user);
    }

    public void saveUser(User user){
        userRepository.save(user);
    }



}
