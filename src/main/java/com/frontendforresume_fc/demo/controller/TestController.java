package com.frontendforresume_fc.demo.controller;

import com.frontendforresume_fc.demo.model.Programme;
import com.frontendforresume_fc.demo.model.Requirement;
import com.frontendforresume_fc.demo.model.User;
import com.frontendforresume_fc.demo.service.AdminService;
import com.frontendforresume_fc.demo.service.ProgrammeService;
import com.frontendforresume_fc.demo.service.RequirementService;
import com.frontendforresume_fc.demo.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashSet;

@RequestMapping("/test")
@Controller
public class TestController {
    @Autowired
    AdminService adminService;

    @Autowired
    UserService userService;

    @Autowired
    ProgrammeService programmeService;

    @Autowired
    RequirementService requirementService;

    private final String testDir = "test/";

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

        return testDir + "test";
    }

    @GetMapping("/register")
    public String register(Model model) {
        User user = new User();
        Programme hit = programmeService.findByName("Hiring in Tech");
        Programme ptf = programmeService.findByName("Promising the Future");

        Programme studentHIT = new Programme("Hiring in Tech");
        Programme studentPTF = new Programme("Promising the Future");
        for(Requirement r : hit.getProgrammeRequirements()){
            studentHIT.addRequirement(requirementService.createRequirement(r.getDescription(), true));
        }
        for(Requirement r : ptf.getProgrammeRequirements()){
            studentPTF.addRequirement(requirementService.createRequirement(r.getDescription(), true));
        }

        user.setStudentRequirements(new HashSet<>());
        user.getStudentRequirements().addAll((Collection)studentHIT);
        user.getStudentRequirements().addAll((Collection)studentPTF);
        model.addAttribute("user",new User());
        model.addAttribute("hitRequirements", studentHIT.getProgrammeRequirements());
        model.addAttribute("ptfRequirements", studentPTF.getProgrammeRequirements());

        return testDir + "register";
    }

    @PostMapping("/register")
    public String processregistration(
            @Valid @ModelAttribute("user") User user,
            @ModelAttribute("requirements") Requirement requirement,
            BindingResult result,
            Model model
    ){
        model.addAttribute("user",user);
        if(result.hasErrors()){
            return "html/register";
        }else{
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
}
