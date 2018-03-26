package com.frontendforresume_fc.demo.service;

import com.frontendforresume_fc.demo.model.Role;
import com.frontendforresume_fc.demo.model.User;
import com.frontendforresume_fc.demo.repository.RoleRepository;
import com.frontendforresume_fc.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

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

    public User findById(long id){
        return  userRepository.findOne(id);
    }

    public Set<User> findByUser(){
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByRole("USER"));
        return userRepository.findUsersByRoles(roles);
    }

    public Set<User> findByAdmin(){
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByRole("ADMIN"));
        return userRepository.findUsersByRoles(roles);
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

    public void deleteUser(User user){
        userRepository.delete(user);
    }



}
