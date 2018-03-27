package com.frontendforresume_fc.demo.controller;

import com.frontendforresume_fc.demo.model.Programme;
import com.frontendforresume_fc.demo.model.User;
import com.frontendforresume_fc.demo.repository.ProgrammeRepository;
import com.frontendforresume_fc.demo.repository.UserRepository;
import com.frontendforresume_fc.demo.service.AdminService;
import com.frontendforresume_fc.demo.service.ProgrammeService;
import com.frontendforresume_fc.demo.service.StudentService;
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
    StudentService studentService;

    @Autowired
    AdminService adminService;

    @Autowired
    ProgrammeRepository programmeRepository;

    @Autowired
    ProgrammeService programmeService;


    @GetMapping("/register")
    public String register(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("user", new User());
//Creating new user and new requirments model for the newly created user

        return "html/register";
    }


    @PostMapping("/register")
    public String processregistration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {

        model.addAttribute("user", user);
        if (result.hasErrors()) {
            return "html/register";
        } else {
//            Pasing in the current created user and requirments and checking username
            userService.saveNewUser(user);
//
        }

        return "redirect:/login";
    }

    @RequestMapping("/login")
    public String login() {
        return "html/login";
    }

    @RequestMapping("/")
    public String index() {
        return "html/index";
    }

    @RequestMapping("/404")
    public String error() {
        return "html/404";
    }

    @RequestMapping("/about_iti")
    public String aboutITI() {
        return "html/about_iti";
    }


    //    /    When going to this route must pass id manually to test need to make anchor tag that includes id from currenllty logined in user  for testing use 1 for id
//    localhost:8080/showhit/1
    @GetMapping("/showhit")
    public String showhitform(Model model) {

        return "html/apply_hit";
    }

    @GetMapping("/showhit/{id}")
    public String showhitform(Model model, @PathVariable("id") long userid) {
        model.addAttribute("user", userRepository.findOne((userid)));
        model.addAttribute("userlist", userRepository.findAll());

        return "html/apply_hit";
    }


    @GetMapping("/submithit")
    public String showhitform(Model model, @ModelAttribute("user") User user) {

        return "html/hitapply_form";
    }

    @PostMapping("/submithit")
    public String processshowhitform(Model model, @Valid @ModelAttribute("user") User user, BindingResult result, Authentication auth) {
        if (result.hasErrors()) {
            return "html/hitapply_form";
        }

        User currUser = userService.findByUsername(auth.getName());
        currUser.setAble2WorkUS(user.getUsworkAuth());
        currUser.setDiplomaStatus(user.getDiplomaStatus());
        currUser.setEnglishStatus(user.getEnglishStatus());
        currUser.setEmploymentStatus(user.getEmploymentStatus());
        currUser.setItcareerInterest(user.getItcareerInterest());
        currUser.setUnderemploymentStatus(user.getUnderemploymentStatus());
        userService.saveUser(currUser);

        Programme hit = programmeService.findByName("Hiring in Tech");
        studentService.apply2Programme(currUser, hit);

        model.addAttribute("applyhituserlist", userRepository.findAll());

        return "redirect:/applicant_dashboard_applied";
    }

    @GetMapping("/showptf")
    public String showptfform(Model model) {

        return "html/apply_ptf";
    }

    //    When going to this route must pass id manually to test need to make anchor tag that includes id from currenllty logined in user  for testing use 1 for id
//    localhost:8080/showptf/1
    @GetMapping("/showptf/{id}")
    public String showptfpage(Model model, @PathVariable("id") long userid) {
        model.addAttribute("user", userRepository.findOne(new Long(userid)));
        model.addAttribute("userlist", userRepository.findAll());
        return "html/apply_ptf";
    }

    @GetMapping("/submitptf")
    public String showptfform(Model model, @ModelAttribute("user") User user) {

        return "html/ptfapply_form";
    }

    @PostMapping("/submitptf")
    public String processshowptfform(Model model, @Valid @ModelAttribute("user") User user, BindingResult result, Authentication auth) {

        {
            if (result.hasErrors()) {
                return "html/ptfapply_form";
            }
        }
        User currUser = userService.findByUsername(auth.getName());
        currUser.setAble2WorkUS(user.getUsworkAuth());
        currUser.setGradYear(user.getGradYear());
        currUser.setSalary(user.getSalary());
        currUser.setObjectoritentedExperience(user.getObjectoritentedExperience());
        currUser.setUnderstandOOP(user.getUnderstandOOP());
        currUser.setMajor(user.getMajor());
        userService.saveUser(currUser);

        Programme ptf = programmeService.findByName("Promising the Future");
        studentService.apply2Programme(currUser, ptf);


        model.addAttribute("applyptfuserlist",userRepository.findAll());

        return "redirect:/applicant_dashboard_applied";
    }



    @RequestMapping("/accepted_students_hit")
    public String viewAcceptedStudentsForHIT(Model model) {
        Programme hit = programmeService.findByName("Hiring in Tech");
        model.addAttribute("counthitaccepted",adminService.getAcceptedStudents(hit));
        model.addAttribute("hitaccepted",adminService.getAcceptedStudents(hit));
        return "html/accepted_students_hit";
    }

    @RequestMapping("/accepted_students_ptf")
    public String viewAcceptedStudentsForPTF(Model model) {
        Programme ptf = programmeService.findByName("Promising the Future");

        model.addAttribute("countptfaccepted",adminService.getNumOfAcceptedStudents(ptf));
        model.addAttribute("ptfaccepted",adminService.getAcceptedStudents(ptf));


        return "html/accepted_students_ptf";
    }


    @RequestMapping("/all_users")
    public String viewAllUsers(Model model) {
        model.addAttribute("userlist", userRepository.findAll());

        return "html/all_users";
    }


    @RequestMapping("/allapplicant")
    public String viewallApplicants(Authentication auth, Model model) {
        model.addAttribute("userlist", userRepository.findAll());
        Programme hit = programmeService.findByName("Hiring in Tech");
        Programme ptf = programmeService.findByName("Promising the Future");



        model.addAttribute("counthit",adminService.getNumOfAcceptedStudents((hit)));
        model.addAttribute("countptf",adminService.getNumOfAppliedStudents(ptf));

//Currently Displaying new user registation output for Based on Registeration form answers needs to be cleaner solution instead of adding to different models.
//        Must pass user model to save these requirments for this user.
        System.out.println(auth.getName());
        return "html/all_applicants";
    }


    @RequestMapping("/add_admin")
    public String addAdmin() {
        return "html/add_admin";
    }


    @RequestMapping("/applicant_resume")
    public String viewApplicantsResume() {
        return "html/applicant_resume";
    }

    @RequestMapping("/applicant_resume/{id}")
    public String viewApplicantsResumebyid(Model model, @PathVariable("id") long userid) {
        User student = userService.findById(userid);
        Programme hit = programmeService.findByName("Hiring in Tech");
        Programme ptf = programmeService.findByName("Promising the Future");
        boolean appliedHIT = student.containsAppliedProgramme(hit);
        boolean appliedPTF = student.containsAppliedProgramme(ptf);
        model.addAttribute("user", student);
        model.addAttribute("userlist", userRepository.findAll());
        model.addAttribute("appliedhit",appliedHIT);
        model.addAttribute("appliedptf",appliedPTF);
        return "html/applicant_resume";
    }



    @RequestMapping("/approveptf/{id}")
    public String approveptfuserResumebyid(Model model, @PathVariable("id") long userid) {
        User user = userService.findById(userid);
        model.addAttribute("user", user);
        Programme ptf = programmeService.findByName("Promising the Future");

        adminService.approveStudent2Programme(user, ptf);
        model.addAttribute("userlist", adminService.getAppliedStudents(ptf));

        return "html/all_applicants";
    }

    @RequestMapping("/approvehit/{id}")
    public String approvehituserResumebyid(Model model, @PathVariable("id") long userid) {
        User user = userService.findById(userid);
        model.addAttribute("user", user);
        Programme hit = programmeService.findByName("Hiring in Tech");
        adminService.approveStudent2Programme(user, hit);
        model.addAttribute("userlist", adminService.getAppliedStudents(hit));

        return "html/all_applicants";
    }


    @RequestMapping("/applicant_dashboard_accepted")
    public String applicantDashboardAccepted() {
        return "html/applicant_dashboard_accepted";
    }


    @RequestMapping("/applicant_dashboard_applied")
    public String applicantDashboardApplied(Authentication auth, Model model, @ModelAttribute ("user") User user ) {
        Programme hit = programmeService.findByName("Hiring in Tech");
        Programme ptf = programmeService.findByName("Promising the Future");
        User currentuser = userService.findByUsername(auth.getName());
        model.addAttribute("programmes", currentuser.getAppliedProgramme());
        return "html/applicant_dashboard_applied";
    }


    @RequestMapping("/applicant_dashboard_approved")
    public String applicantDashboardApproved(Authentication auth, Model model, @ModelAttribute ("user") User user ) {
        Programme hit = programmeService.findByName("Hiring in Tech");
        Programme ptf = programmeService.findByName("Promising the Future");
        user = userService.findByUsername(auth.getName());
        model.addAttribute("approvedprogram",user.getApprovedProgramme());
        return "html/applicant_dashboard_approved";
    }


    @RequestMapping("/list_of_programs")
    public String viewListOfPrograms(Model model) {
        return "html/list_of_programs";
    }


    @RequestMapping("/blog")
    public String blog() {
        return "html/blog";
    }

    @RequestMapping("/list_of_programs_admin")
    public String viewListOfProgramsAdminView() {
        return "html/list_of_programs_admin";
    }


    @RequestMapping("/post_program")
    public String postProgram() {
        return "html/post_program";
    }
}
