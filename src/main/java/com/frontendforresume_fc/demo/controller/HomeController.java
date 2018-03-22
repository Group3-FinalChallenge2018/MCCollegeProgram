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

    @RequestMapping("/all_applicants")
    public String allApplicants() {
        return "html/all_applicants";
    }

    @RequestMapping("/applicant_dashboard_accepted")
    public String applicantDashboardAccepted() {
        return "html/applicant_dashboard_accepted";
    }

    @RequestMapping("/applicant_dashboard_applied")
    public String applicantDashboardApplied() {
        return "html/applicant_dashboard_applied";
    }

    @RequestMapping("/applicant_dashboard_approved")
    public String applicantDashboardApproved() {
        return "html/applicant_dashboard_approved";
    }

    @RequestMapping("/applicant_resume")
    public String viewApplicantsResume() {
        return "html/applicant_resume";
    }

    @RequestMapping("/applicants_hit")
    public String viewHiTApplicants() {
        return "html/applicants_hit";
    }

    @RequestMapping("/applicants_ptf")
    public String viewPtFApplicants() { return "html/applicants_ptf"; }

    @RequestMapping("/apply_hit")
    public String applyToHiT() {
        return "html/apply_hit";
    }

    @RequestMapping("/apply_ptf")
    public String applyToPtF() {
        return "html/apply_ptf";
    }

    @RequestMapping("/blog")
    public String blog() { return "html/blog"; }

    @RequestMapping("/contact")
    public String contact() { return "html/contact"; }

    @RequestMapping("/faqs")
    public String faqs() { return "html/faqs"; }

    @RequestMapping("/list_of_programs")
    public String viewListOfPrograms() { return "html/list_of_programs"; }

    @RequestMapping("/list_of_programs_admin")
    public String viewListOfProgramsAdminView() { return "html/list_of_programs_admin"; }

    @RequestMapping("/login")
    public String login() { return "html/login"; }

    @RequestMapping("/post_program")
    public String postProgram() {
        return "html/post_program";
    }

    @RequestMapping("/register")
    public String register() {
        return "html/register";
    }









}
