package com.frontendforresume_fc.demo.controller;

import com.frontendforresume_fc.demo.model.Programme;
import com.frontendforresume_fc.demo.model.Requirement;
import com.frontendforresume_fc.demo.model.User;
import com.frontendforresume_fc.demo.repository.RequirementRepository;
import com.frontendforresume_fc.demo.repository.UserRepository;
import com.frontendforresume_fc.demo.service.AdminService;
import com.frontendforresume_fc.demo.service.ProgrammeService;
import com.frontendforresume_fc.demo.service.RequirementService;
import com.frontendforresume_fc.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;

@Controller
public class HomeController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RequirementRepository requirementRepository;

    @Autowired
    AdminService adminService;

    @Autowired
    ProgrammeService programmeService;

    @Autowired
    RequirementService requirementService;

    @RequestMapping("/")
    public String index() {
        return "html/index";
    }

    @RequestMapping("/login")
    public String login() {
        return "html/login";
    }

    @GetMapping("/register")
    public String register(@ModelAttribute("user") User user ,@ModelAttribute("requirements") Requirement requirement, Model model ) {
        model.addAttribute("user",new User());
        model.addAttribute("requirements",new Requirement());
//Creating new user and new requirments model for the newly created user

        return "html/testregister";
    }

    @PostMapping("/register")
    public String processregistration(@Valid @ModelAttribute("user") User user,@ModelAttribute("requirements") Requirement requirement, BindingResult result, Model model ){

        model.addAttribute("user",user);
        if(result.hasErrors()){
            return "html/register";
        }else{
//            Pasing in the current created user and requirments and checking username
            userService.saveNewUser(user);
            userService.findByUsername(user.getUsername());
            Programme programme = programmeService.findByName("Promising the Future");
            user.setStudentRequirements(new HashSet<>());

            user.addRequirement(requirementService.createRequirement("Basic understanding of object oriented programming", true));
            user.addRequirement(requirementService.createRequirement("Previous experience with an object-oriented language", true));
            user.addRequirement(requirementService.createRequirement("Major in Computer Science / Information Systems", false));
            user.addRequirement(requirementService.createRequirement("Graduated within the last 6 years", false));
            user.addRequirement(requirementService.createRequirement("Currently earning 42,000 or less", false));
            user.addRequirement(requirementService.createRequirement("Be able to work in the United States", true));

            HashSet<Requirement> userEligibilty =  adminService.compareUserAndProgrammeRequirements(user, programme);
            model.addAttribute("programme", programme.getProgrammeRequirements());
            model.addAttribute("students", user.getStudentRequirements());
            model.addAttribute( "requirementMatch", userEligibilty);

        }

//        Must redirect to login to new rigister user form input within /applicant_resume route checkinng for requirement descriptions and and boolean values
        return "redirect:/login";
    }

    @RequestMapping("/testr")
    public String testrequirements(Model model){
        User user = userService.findByUsername("clark");
        Programme programme = programmeService.findByName("Promising the Future");

        user.setStudentRequirements(new HashSet<>());

        user.addRequirement(requirementService.createRequirement("Basic understanding of object oriented programming", true));
        user.addRequirement(requirementService.createRequirement("Previous experience with an object-oriented language", true));
        user.addRequirement(requirementService.createRequirement("Major in Computer Science / Information Systems", false));
        user.addRequirement(requirementService.createRequirement("Graduated within the last 6 years", false));
        user.addRequirement(requirementService.createRequirement("Currently earning 42,000 or less", false));
        user.addRequirement(requirementService.createRequirement("Be able to work in the United States", true));

        HashSet<Requirement> userEligibilty =  adminService.compareUserAndProgrammeRequirements(user, programme);

        model.addAttribute("programme", programme.getProgrammeRequirements());
        model.addAttribute("students", user.getStudentRequirements());
        model.addAttribute( "requirementMatch", userEligibilty);

        return "html/testapplicant_resume";
    }


    @RequestMapping("/all_users")
    public String viewAllUsers(Model model) {
        model.addAttribute("userlist",userRepository.findAll());

        return "html/all_users";
    }


    @RequestMapping("/applicant_resume")
    public String viewApplicantsResume(Authentication auth,Model model,@ModelAttribute("requirements") Requirement requirement,@ModelAttribute("user") User user ) {


//Currently Displaying new user registation output for Based on Registeration form answers needs to be cleaner solution instead of adding to different models.
//        Must pass user model to save these requirments for this user.
        System.out.println(auth.getName());
        model.addAttribute("requirementsforuser",requirementService.getRequirement("Basic understanding of object oriented programming",requirement.isAnswer()));
        model.addAttribute("oobjrequirementsforuser",requirementService.getRequirement("Previous experience with an object-oriented language", requirement.isAnswer()));

        return "html/testapplicant_resume";
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
