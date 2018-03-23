package com.frontendforresume_fc.demo.controller;

import com.frontendforresume_fc.demo.model.Programme;
import com.frontendforresume_fc.demo.model.User;
import com.frontendforresume_fc.demo.service.AdminService;
import com.frontendforresume_fc.demo.service.ProgrammeService;
import com.frontendforresume_fc.demo.service.StudentService;
import com.frontendforresume_fc.demo.service.UserService;
import com.google.common.collect.Lists;
import it.ozimov.springboot.mail.model.Email;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmail;
import it.ozimov.springboot.mail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.internet.InternetAddress;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @Autowired
    ProgrammeService programmeService;

    @Autowired
    StudentService studentService;

    @Autowired
    UserService userService;

    @Autowired
    EmailService emailService;

    private final String adminDir = "admin/";

    @RequestMapping("/students/hit")
    public String getStudentListHIT(Model model) {
        User clark = userService.findByUsername("clark");
        User harry = userService.findByUsername("harry");

        sendEmailWithoutTemplating();

        Programme programme = programmeService.findByName("Hiring in Tech");

        studentService.apply2Programme(clark, programme);
        studentService.apply2Programme(harry, programme);

        model.addAttribute("students", adminService.getAppliedStudents(programme));
        model.addAttribute("programme", programme);
        return adminDir + "listStudents";
    }

    @RequestMapping("/students/ptf")
    public String getStudentListPTF(Model model) {
        Programme programme = programmeService.findByName("Promising the Future");
        model.addAttribute("students", adminService.getAppliedStudents(programme));
        model.addAttribute("programme", programme);
        return adminDir + "listStudents";
    }

    @RequestMapping("/approve/hit/{id}")
    public String approveHITStudent(
            @PathVariable("id") long student_id,
            Model model) {
        User user = userService.findById(student_id);
        Programme programme = programmeService.findByName("Hiring in Tech");
        adminService.approveStudent2Programme(user, programme);
        model.addAttribute("students", userService.findByUser());
        return adminDir + "listStudents";
    }

    @RequestMapping("/approve/ptf/{id}")
    public String approvePTFStudent(
            @PathVariable("id") long student_id,
            Model model) {
        User user = userService.findById(student_id);
        Programme programme = programmeService.findByName("Promising the Future");
        adminService.approveStudent2Programme(user, programme);
        model.addAttribute("students", userService.findByUser());
        return adminDir + "listStudents";
    }

    public void sendEmailWithoutTemplating() {
        final Email email;
        try {
            email = DefaultEmail.builder()
                    .from(new InternetAddress("cicero@mala-tempora.currunt", "Marco Tullio Cicerone "))
                    .to(Lists.newArrayList(new InternetAddress("sangseokum@gmail.com", "Sangseok Um")))
                    .subject("Laelius de amicitia")
                    .body("Firmamentum autem stabilitatis constantiaeque eius, quam in amicitia quaerimus, fides est.")
                    .encoding("UTF-8").build();

            emailService.send(email);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }
}
