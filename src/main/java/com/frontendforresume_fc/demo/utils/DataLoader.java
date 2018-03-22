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
    public void run(String... strings) throws Exception {
        Role r = new Role();
        r.setRole("USER");
        roleRepository.save(r);

        r = new Role();
        r.setRole("ADMIN");
        roleRepository.save(r);
//Saved user and progam With Travis new Model Design
        User student = new User("password", "clark", "Clark", "Kent", "clark@kent.com", "YES", "YES", "YES", "YES", "YES", "YES", "YES", "YES", "YES", "parry@kent.com");
        student.setUnderstandOOP("YES");
        student.setComfortableComputer("YES");
        student.setAble2WorkUS("YES");
        userService.saveNewUser(student);

        User student2 = new User("password", "harry", "Harry", "Potter", "Yes", "YES", "YES", "YES", "No", "No", "YES", "YES", "YES", "YES", "harry@kent.com");
        student2.setUnderstandOOP("YES");
        student2.setComfortableComputer("YES");
        student2.setAble2WorkUS("YES");
        userService.saveNewUser(student2);

        User student3 = new User("password", "tony", "Tony", "stark", "Yes", "YES", "YES", "YES", "No", "No", "YES", "YES", "YES", "YES", "harry@kent.com");
        student3.setUnderstandOOP("YES");
        student3.setComfortableComputer("YES");
        student3.setAble2WorkUS("YES");
        userService.saveNewUser(student3);

        User student4 = new User("password", "holy", "Holy", "Grail", "Yes", "YES", "YES", "YES", "No", "No", "YES", "YES", "YES", "YES", "harry@kent.com");
        student4.setUnderstandOOP("YES");
        student4.setComfortableComputer("YES");
        student4.setAble2WorkUS("YES");
        userService.saveNewUser(student4);


        User admin = new User("password", "admin", "Dave", "Wolfman", "admin@gmail.com");
        userService.saveNewAdmin(admin);

        User admin2 = new User("password", "admin2", "Conor", "McGregor", "admin2@gmail.com");
        userService.saveNewAdmin(admin2);


        Programme hit = new Programme("Hiring in Tech");
        hit.setEnglishStatus("YES");
        hit.setEmploymentStatus("YES");
        hit.setUnderemploymentStatus("YES");
        hit.setDiplomaStatus("YES");
        hit.setItcareerInterest("YES");
        hit.setMajor("YES");
        hit.setSalary("YES");
        hit.setUsworkAuth("YES");
        hit.setObjectoritentedExperience("YES");
        hit.setGradYear("YES");
        hit.setComfortableComputer("YES");
        hit.setUnderstandOOP("YES");
        hit.setAble2WorkUS("YES");

        programmeRepository.save(hit);

        Programme ptf = new Programme("Promising the Future");
        ptf.setEnglishStatus("YES");
        ptf.setEmploymentStatus("YES");
        ptf.setDiplomaStatus("YES");
        ptf.setItcareerInterest("YES");
        ptf.setMajor("YES");
        ptf.setSalary("YES");
        ptf.setUsworkAuth("YES");
        ptf.setObjectoritentedExperience("YES");
        ptf.setGradYear("YES");
        ptf.setComfortableComputer("YES");
        ptf.setUnderstandOOP("YES");
        ptf.setUnderemploymentStatus("YES");
        ptf.setAble2WorkUS("YES");

        programmeRepository.save(ptf);
    }
}
