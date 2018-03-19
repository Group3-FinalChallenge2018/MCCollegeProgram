package com.frontendforresume_fc.demo.service;

import com.frontendforresume_fc.demo.model.Requirement;
import com.frontendforresume_fc.demo.repository.RequirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequirementService {
    @Autowired
    RequirementRepository requirementRepository;

    public Requirement createRequirement(String description){
        Requirement requirement = new Requirement(description, true);
        requirementRepository.save(requirement);

        return requirement;
    }
}