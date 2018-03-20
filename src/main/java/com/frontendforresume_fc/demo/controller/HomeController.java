package com.frontendforresume_fc.demo.controller;

import com.frontendforresume_fc.demo.model.User;
import com.frontendforresume_fc.demo.repository.UserRepository;
import com.frontendforresume_fc.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    public String index() {
        return "html/index";
    }

    @RequestMapping("/login")
    public String login() {
        return "html/login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user",new User());
        return "html/register";
    }

    @PostMapping("/register")
    public String processregistration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model ){

        model.addAttribute("user",user);
        if(result.hasErrors()){
            return "html/register";
        }else{
            userService.saveNewUser(user);
            model.addAttribute("message","User Account Successfully Created");

        }
        return "html/index";
    }



    @RequestMapping("/all_users")
    public String viewAllUsers(Model model) {
        model.addAttribute("userlist",userRepository.findAll());

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
