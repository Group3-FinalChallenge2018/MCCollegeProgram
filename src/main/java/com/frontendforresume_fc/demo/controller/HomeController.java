package com.frontendforresume_fc.demo.controller;

import com.frontendforresume_fc.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String index() {
        return "html/index";
    }


    @RequestMapping("/all_users")
    public String viewAllUsers() {
        return "html/all_users";
    }


    @RequestMapping("/user_resume")
    public String viewUsersResume() {
        return "html/user_resume";
    }


    @RequestMapping("/accepted_students_hit")
    public String viewAcceptedStudentsForHIT() {
        return "html/accepted_students_hit";
    }

    @RequestMapping("/accepted_students_ptf")
    public String viewAcceptedStudentsForPTF() {
        return "html/accepted_students_ptf";
    }

    @RequestMapping("/list_of_programs")
    public String viewListOfPrograms() {
        return "html/list_of_programs";
    }

    @RequestMapping("/add_admin")
    public String addAdmin() {
        return "html/add_admin";
    }
}
