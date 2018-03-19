package com.frontendforresume_fc.demo.controller;

import com.frontendforresume_fc.demo.model.User;
import com.frontendforresume_fc.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

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
