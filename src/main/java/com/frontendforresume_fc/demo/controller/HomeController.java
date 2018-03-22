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


//    @GetMapping("/register")
//    public String register(Model model) {
//        model.addAttribute("user",new User());
//        return "html/register";
//    }
//
//    @PostMapping("/register")
//    public String processregistration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model ){
//
//        model.addAttribute("user",user);
//        if(result.hasErrors()){
//            return "html/register";
//        }else{
//            userService.saveNewUser(user);
//            model.addAttribute("message","User Account Successfully Created");
//
//        }
//        return "html/index";
//    }
//
//
//
//    @RequestMapping("/all_applicants")
//    public String viewAllApplicants(Model model) {
//        model.addAttribute("userlist",userRepository.findAll());
//
//        return "html/all_applicants";
//    }


    @RequestMapping("/")
    public String index() {
        return "html/index";
    }

    @RequestMapping("/404")
    public String error() { return "html/404"; }

    @RequestMapping("/about_iti")
    public String aboutITI() {
        return "html/about_iti";
    }

    @RequestMapping("/accepted_students_hit")
    public String viewAcceptedStudentsForHIT() {
        return "html/accepted_students_hit";
    }

    @RequestMapping("/accepted_students_ptf")
    public String viewAcceptedStudentsForPTF() {
        return "html/accepted_students_ptf";
    }

    @RequestMapping("/add_admin")
    public String addAdmin() {
        return "html/add_admin";
    }

    @RequestMapping("/add_applicants")
    public String addApplicant() {
        return "html/add_applicants";
    }


    @RequestMapping("/register")
    public String register() {
        return "html/register";
    }



    @RequestMapping("/login")
    public String login() {
        return "html/login";
    }

    @RequestMapping("/applicant_resume")
    public String viewApplicantsResume() {
        return "html/applicant_resume";
    }



    @RequestMapping("/list_of_programs")
    public String viewListOfPrograms() {
        return "html/list_of_programs";
    }


    @RequestMapping("/blog")
    public String blog() { return "html/blog"; }



}
