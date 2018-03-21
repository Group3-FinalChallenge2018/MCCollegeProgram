package com.frontendforresume_fc.demo.utils;

import com.frontendforresume_fc.demo.model.Programme;
import com.frontendforresume_fc.demo.model.Role;
import com.frontendforresume_fc.demo.model.User;
import com.frontendforresume_fc.demo.repository.ProgrammeRepository;
import com.frontendforresume_fc.demo.repository.RoleRepository;
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
        hit.setEnglishLearner("YES");
        hit.setUnemployed("YES");
        hit.setUnderemployed("YES");
        hit.setComfortableComputer("YES");
        hit.setInterestIT("YES");
        hit.setHighschool("YES");
        hit.setLegalUS("YES");
        programmeRepository.save(hit);

        Programme ptf = new Programme("Promising the Future");
        ptf.setOop("YES");
        ptf.setExperienceOOP("YES");
        ptf.setMajorCS("YES");
        ptf.setGraduated6("YES");
        ptf.setEarning42000("YES");
        ptf.setWorkUS("YES");
        programmeRepository.save(ptf);
    }
}
