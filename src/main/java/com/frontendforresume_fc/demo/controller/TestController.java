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
import org.springframework.web.bind.annotation.RequestMapping;

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

//    @RequestMapping("/testr")
//    public String testrequirements(Model model){
//        User user = userService.findByUsername("clark");
//        Programme programme = programmeService.findByName("Promising the Future");
//
//        user.setStudentRequirements(new HashSet<>());
//
//        user.addRequirement(requirementService.createRequirement("Basic understanding of object oriented programming", true));
//        user.addRequirement(requirementService.createRequirement("Previous experience with an object-oriented language", true));
//        user.addRequirement(requirementService.createRequirement("Major in Computer Science / Information Systems", false));
//        user.addRequirement(requirementService.createRequirement("Graduated within the last 6 years", false));
//        user.addRequirement(requirementService.createRequirement("Currently earning 42,000 or less", false));
//        user.addRequirement(requirementService.createRequirement("Be able to work in the United States", true));
//
//        HashSet<Requirement> userEligibilty =  adminService.compareUserAndProgrammeRequirements(user, programme);
//
//        model.addAttribute("programme", programme.getProgrammeRequirements());
//        model.addAttribute("students", user.getStudentRequirements());
//        model.addAttribute( "requirementMatch", userEligibilty);
//
//        return "test";
//    }
}
