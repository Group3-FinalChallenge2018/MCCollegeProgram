package com.frontendforresume_fc.demo.utils;

import com.frontendforresume_fc.demo.model.Programme;
import com.frontendforresume_fc.demo.model.Requirement;
import com.frontendforresume_fc.demo.model.Role;
import com.frontendforresume_fc.demo.model.User;
import com.frontendforresume_fc.demo.repository.ProgrammeRepository;
import com.frontendforresume_fc.demo.repository.RequirementRepository;
import com.frontendforresume_fc.demo.repository.RoleRepository;
import com.frontendforresume_fc.demo.repository.UserRepository;
import com.frontendforresume_fc.demo.service.RequirementService;
import com.frontendforresume_fc.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ProgrammeRepository programmeRepository;

    @Autowired
    RequirementService requirementService;


@Autowired
    UserService userService;

    @Override
    public void run(String... strings) throws Exception{
        Role r = new Role();
        r.setRole("USER");
        roleRepository.save(r);

        r = new Role();
        r.setRole("ADMIN");
        roleRepository.save(r);
//
//        User student = new User("password", "clark", "Clark", "Kent", "clark@kent.com");
//        userService.saveNewUser(student);
//
//        User student2 = new User("password", "harry", "Harry", "Potter", "harry@kent.com");
//        userService.saveNewUser(student2);
//
//        User student3 = new User("password", "tony", "Tony", "stark", "tony@kent.com");
//        userService.saveNewUser(student3);
//
//        User student4 = new User("password", "holy", "Holy", "Grail", "holy@kent.com");
//        userService.saveNewUser(student4);
//
//        User student5 = new User("password", "hola", "Hola", "hi", "hola@kent.com");
//        userService.saveNewUser(student5);
//
//        User student6 = new User("password", "samsung", "Samsung", "Galaxy", "samsung@kent.com");
//        userService.saveNewUser(student6);
//
//        User student7 = new User("password", "yolo", "Yolo", "Man", "yolo@kent.com");
//        userService.saveNewUser(student7);
//
//        User admin = new User("password", "admin", "admink", "adminKent", "admin@kent.com");
//        userService.saveNewAdmin(admin);
//
//        User admin2 = new User("password", "admin2", "admink", "adminKent", "admin2@kent.com");
//        userService.saveNewAdmin(admin2);


        Programme hit = new Programme("Hiring in Tech");
        hit.setProgrammeRequirements(new HashSet<>());
        hit.addRequirement(requirementService.createRequirement("English Language Learner", true));
        hit.addRequirement(requirementService.createRequirement("Unemployed with barriers to employment", true));
        hit.addRequirement(requirementService.createRequirement("Underemployed with barriers to better employment", true));
        hit.addRequirement(requirementService.createRequirement("Be comfortable using computers for everyday purposes", true));
        hit.addRequirement(requirementService.createRequirement("Have a strong interest in an IT career", true));
        hit.addRequirement(requirementService.createRequirement("Have a high school diploma or GED", true));
        hit.addRequirement(requirementService.createRequirement("Be legally authorized to work in the U.S.", true));
        programmeRepository.save(hit);

        Programme ptf = new Programme("Promising the Future");
        ptf.setProgrammeRequirements(new HashSet<>());
        ptf.addRequirement(requirementService.createRequirement("Basic understanding of object oriented programming", true));
        ptf.addRequirement(requirementService.createRequirement("Previous experience with an object-oriented language", true));
        ptf.addRequirement(requirementService.createRequirement("Major in Computer Science / Information Systems", true));
        ptf.addRequirement(requirementService.createRequirement("Graduated within the last 6 years", true));
        ptf.addRequirement(requirementService.createRequirement("Currently earning 42,000 or less", true));
        ptf.addRequirement(requirementService.createRequirement("Be able to work in the United States", true));
        programmeRepository.save(ptf);
    }
}
