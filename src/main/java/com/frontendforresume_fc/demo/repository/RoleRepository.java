package com.frontendforresume_fc.demo.repository;

import com.frontendforresume_fc.demo.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByRole(String role);
}
