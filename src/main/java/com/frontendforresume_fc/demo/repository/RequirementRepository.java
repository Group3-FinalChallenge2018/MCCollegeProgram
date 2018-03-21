package com.frontendforresume_fc.demo.repository;

import com.frontendforresume_fc.demo.model.Requirement;
import org.springframework.data.repository.CrudRepository;

public interface RequirementRepository extends CrudRepository<Requirement, Long> {

    Iterable<Requirement> findAllByDescription(String description );
}
