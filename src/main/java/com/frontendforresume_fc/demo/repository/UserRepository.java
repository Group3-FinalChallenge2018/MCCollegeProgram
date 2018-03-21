package com.frontendforresume_fc.demo.repository;


import com.frontendforresume_fc.demo.model.Programme;
import com.frontendforresume_fc.demo.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.HashSet;
import java.util.Set;

public interface UserRepository extends CrudRepository<User, Long> {
    User findUserByUsername(String username);
    HashSet<User> findUsersByAppliedProgrammeContains(Programme programme);
    int countByUsername(int usernumber);
}
