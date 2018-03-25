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
    public String register(@ModelAttribute("user") User user, Model model ) {
        model.addAttribute("user",new User());
//Creating new user and new requirments model for the newly created user

        return "html/register";
    }


    @PostMapping("/register")
    public String processregistration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model ){

        model.addAttribute("user",user);
        if(result.hasErrors()){
            return "html/register";
        }else{



//            Pasing in the current created user and requirments and checking username
            userService.saveNewUser(user);
            userService.findByUsername(user.getUsername());
            Programme programme = programmeService.findByName("Promising the Future");

            System.out.println(user.getEmploymentStatus());
            System.out.println(programme.getEmploymentStatus());
            System.out.println(user.getEnglishStatus());
            System.out.println(programme.getEnglishStatus());
            System.out.println(user.getDiplomaStatus());
            System.out.println(programme.getDiplomaStatus());
//
        }

//        Must redirect to login to new rigister user form input within /applicant_resume route checkinng for requirement descriptions and and boolean values
        return "redirect:/login";
    }


    @RequestMapping("/")
    public String index() {

//        if (user.equals(null)){
//            return "redirect:/"
//        }
        return "html/index";
    }

    @RequestMapping("/404")
    public String error() { return "html/404"; }

    @RequestMapping("/about_iti")
    public String aboutITI() {
        return "html/about_iti";
    }



//    /    When going to this route must pass id manually to test need to make anchor tag that includes id from currenllty logined in user  for testing use 1 for id
//    localhost:8080/showhit/1
@GetMapping("/showhit")
public String showhitform(Model model){

    return "html/apply_hit";
}

    @GetMapping("/showhit/{id}")
    public String showhitform(Model model,@PathVariable("id") long userid){
        model.addAttribute("user",userRepository.findOne( new Long(userid)));
        model.addAttribute("userlist",userRepository.findAll());

        return "html/apply_hit";
    }



    @GetMapping("/submithit")
    public String showhitform(Model model,@ModelAttribute("user") User user){

        return "html/hitapply_form";
    }

    @PostMapping("/submithit")
    public String processshowhitform(Model model, @Valid @ModelAttribute("user") User user, BindingResult result,Authentication auth){

        {
            if (result.hasErrors()) {
                return "html/hitapply_form";
            }
        }
        userRepository.save(user);
        model.addAttribute("applyhituserlist",userRepository.findAll());

//        Somehgow primary key of programme primary key column(s) is changed. throwing error User altered from 1 to 7
        User tempUser = userService.findByUsername(auth.getName());

        tempUser.setAble2WorkUS(user.getUsworkAuth());
        tempUser.setDiplomaStatus(user.getDiplomaStatus());
        tempUser.setEmail(user.getEmail());
        tempUser.setEnglishStatus(user.getEnglishStatus());
        tempUser.setFirstName(user.getFirstName());
        tempUser.setEmploymentStatus(user.getEmploymentStatus());
        tempUser.setGradYear(user.getGradYear());
        tempUser.setSalary(user.getSalary());
        tempUser.setUnderemploymentStatus(user.getUnderemploymentStatus());
        tempUser.setUnderstandOOP(user.getObjectoritentedExperience());
        tempUser.setMajor(user.getMajor());
        userRepository.save(tempUser);

        Programme hit = programmeService.findByName("Hiring in Tech");
        studentService.apply2Programme(tempUser, hit);
        adminService.approveStudent2Programme(tempUser,hit);

        return "html/applicants_hit";
    }

    @GetMapping("/showptf")
    public String showptfform(Model model){

        return "html/apply_ptf";
    }
//    When going to this route must pass id manually to test need to make anchor tag that includes id from currenllty logined in user  for testing use 1 for id
//    localhost:8080/showptf/1
    @GetMapping("/showptf/{id}")
    public String showptfpage(Model model, @PathVariable("id") long userid){
        model.addAttribute("user",userRepository.findOne( new Long(userid)));
        model.addAttribute("userlist",userRepository.findAll());
        return "html/apply_ptf";
    }

    @GetMapping("/submitptf")
    public String showptfform(Model model,@ModelAttribute("user") User user){

        return "html/ptfapply_form";
    }

    @PostMapping("/submitptf")
    public String processshowptfform(Model model, @Valid @ModelAttribute("user") User user, BindingResult result,Authentication auth){

        {
            if (result.hasErrors()) {
                return "html/ptfapply_form";
            }
        }
        userRepository.save(user);
        model.addAttribute("applyptfuserlist",userRepository.findAll());

//        User tempUser = userService.findByUsername(user.getUsername());
//        Programme ptf = programmeService.findByName("Promising the Future");
//
//        tempUser.setAble2WorkUS(user.getUsworkAuth());
//        tempUser.setDiplomaStatus(user.getDiplomaStatus());
//        tempUser.setEmail(user.getEmail());
//        tempUser.setEnglishStatus(user.getEnglishStatus());
//        tempUser.setFirstName(user.getFirstName());
//        tempUser.setLastName(user.getLastName());
//        tempUser.setEmploymentStatus(user.getEmploymentStatus());
//        tempUser.setGradYear(user.getGradYear());
//        tempUser.setId(user.getId());
//        tempUser.setSalary(user.getSalary());
//        tempUser.setUnderemploymentStatus(user.getUnderemploymentStatus());
//        tempUser.setUnderstandOOP(user.getObjectoritentedExperience());
//        tempUser.setMajor(user.getMajor());


//        During post mapping after clicking sumbit throws javax.persistence.NonUniqueResultException: result returns more than one elements
//
//        Then it is most likely that your database does not have even a single record matching your query OR you have too many results being returned. Might be due to temp user.
//
//        studentService.apply2Programme(tempUser, ptf);
//        programmeRepository.save(ptf);
        userService.saveNewUser(user);

        return "html/applicants_ptf";
    }

    @RequestMapping("/accepted_students_hit")
    public String viewAcceptedStudentsForHIT() {
        return "html/accepted_students_hit";
    }

    @RequestMapping("/accepted_students_ptf")
    public String viewAcceptedStudentsForPTF() {
        return "html/accepted_students_ptf";
    }


    @RequestMapping("/all_users")
    public String viewAllUsers(Model model) {
        model.addAttribute("userlist",userRepository.findAll());

        return "html/all_users";
    }


    @RequestMapping("/allapplicant")
    public String viewallApplicants(Authentication auth,Model model) {
//        Programme programme;
//
//        model.addAttribute("userlist",adminService.getAppliedStudents(user));


        model.addAttribute("userlist",userRepository.findAll());

//Currently Displaying new user registation output for Based on Registeration form answers needs to be cleaner solution instead of adding to different models.
//        Must pass user model to save these requirments for this user.
        System.out.println(auth.getName());
//        model.addAttribute("requirementsforuser",requirementService.getRequirement("Basic understanding of object oriented programming",requirement.isAnswer()));
//        model.addAttribute("oobjrequirementsforuser",requirementService.getRequirement("Previous experience with an object-oriented language", requirement.isAnswer()));

        return "html/all_applicants";
    }





    @RequestMapping("/add_admin")
    public String addAdmin() {
        return "html/add_admin";
    }

    @RequestMapping("/all_applicants")
    public String allApplicants() {
        return "html/all_applicants";
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

    @RequestMapping("/applicant_resume/{id}")
    public String viewApplicantsResumebyid(Model model, @PathVariable("id") long userid) {
        model.addAttribute("user",userRepository.findOne( new Long(userid)));
        model.addAttribute("userlist",userRepository.findAll());

        return "html/applicant_resume";
    }

    @RequestMapping("/approveptf/{id}")
    public String approveptfuserResumebyid(Model model, @PathVariable("id") long userid) {
        model.addAttribute("user",userRepository.findOne( new Long(userid)));
        User user = userService.findById(userid);
        Programme programme = programmeService.findByName("Promising the Future");

        adminService.approveStudent2Programme(user,programme);
        model.addAttribute("userlist",userRepository.findAll());

        return "html/all_applicants";
    }

    @RequestMapping("/approvehit/{id}")
    public String approvehituserResumebyid(Model model, @PathVariable("id") long userid) {
        model.addAttribute("user",userRepository.findOne( new Long(userid)));
        User user = userService.findById(userid);
        Programme programme = programmeService.findByName("Hiring in Tech");

        adminService.approveStudent2Programme(user,programme);
        model.addAttribute("userlist",userRepository.findAll());

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


    @RequestMapping("/list_of_programs")
    public String viewListOfPrograms(Model model) {
//        model.addAttribute("user",userRepository.findOne( new Long(userid)));
//        @PathVariable("id") long userid
        return "html/list_of_programs";
    }


    @RequestMapping("/blog")
    public String blog() { return "html/blog"; }

    @RequestMapping("/list_of_programs_admin")
    public String viewListOfProgramsAdminView() { return "html/list_of_programs_admin"; }


    @RequestMapping("/post_program")
    public String postProgram() {
        return "html/post_program";
    }
}
