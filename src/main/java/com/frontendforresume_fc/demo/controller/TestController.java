package com.frontendforresume_fc.demo.controller;

import com.frontendforresume_fc.demo.model.Programme;
import com.frontendforresume_fc.demo.model.User;
import com.frontendforresume_fc.demo.service.AdminService;
import com.frontendforresume_fc.demo.service.ProgrammeService;
import com.frontendforresume_fc.demo.service.StudentService;
import com.frontendforresume_fc.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;

@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    UserService userService;

    @Autowired
    ProgrammeService programmeService;

    @Autowired
    StudentService studentService;

    @Autowired
    AdminService adminService;

    @RequestMapping("/")
    public String test(Model model){
        User clark = userService.findByUsername("clark");
        User harry = userService.findByUsername("harry");
        User tony = userService.findByUsername("tony");
        User holy = userService.findByUsername("holy");

        User admin = userService.findByUsername("admin");
        Programme programme = programmeService.findByName("Promising the Future");

        studentService.apply2Programme(clark, programme);
        studentService.apply2Programme(harry, programme);
        HashSet<User> appliedStudentSet = adminService.getAppliedStudents(programme);

        adminService.approveStudent2Programme(clark, programme);
        adminService.approveStudent2Programme(harry, programme);

        model.addAttribute("appliedStudents", appliedStudentSet);

        return "test/index";
    }

}
