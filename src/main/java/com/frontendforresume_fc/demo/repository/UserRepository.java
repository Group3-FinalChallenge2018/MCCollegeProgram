package com.frontendforresume_fc.demo.repository;


import com.frontendforresume_fc.demo.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface UserRepository extends CrudRepository<User, Long> {
    User findUserByUsername(String username);
}
