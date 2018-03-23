//package com.frontendforresume_fc.demo;
//
//import com.frontendforresume_fc.demo.model.Programme;
//import com.frontendforresume_fc.demo.model.User;
//import com.frontendforresume_fc.demo.service.*;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class FrontEndForResumeFcApplicationTests {
//    @Autowired
//    UserService userService;
//
//    @Autowired
//    ProgrammeService programmeService;
//
//    @Autowired
//    StudentService studentService;
//
//    @Autowired
//    AdminService adminService;
//
//    @Test
//    public void compareUserProgramReq() {
//        User user = userService.findByUsername("clark");
//        Programme programme = programmeService.findByName("Promising the Future");
//
//        adminService.compareUserAndProgrammeRequirements(user, programme);
//    }
//
//    @Test
//    public void addOtherAdministrator() {
//        User admin = userService.findByUsername("admin2");
//        admin = new User("password", "admin3", "Rob", "Starrk", "rob@gmail.com");
//        userService.saveNewAdmin(admin);
//        Set<User> users = userService.findByAdmin();
//    }
//
//    @Test
//    public void baseCase() {
//        User clark = userService.findByUsername("clark");
//        User harry = userService.findByUsername("harry");
//        User tony = userService.findByUsername("tony");
//        User holy = userService.findByUsername("holy");
//
//        User admin = userService.findByUsername("admin");
//        Programme programme = programmeService.findByName("Promising the Future");
//
//        studentService.apply2Programme(clark, programme);
//        studentService.apply2Programme(harry, programme);
//        HashSet<User> appliedStudentSet = adminService.getAppliedStudents(programme);
//        adminService.approveStudent2Programme(clark, programme);
//        adminService.approveStudent2Programme(harry, programme);
//        studentService.getApprovedProgramme(clark);
//        studentService.getApprovedProgramme(tony);
//        studentService.acceptProgramme(clark, programme);
//        studentService.acceptProgramme(harry, programme);
//        adminService.getNumOfAcceptedStudents(programme);
//        adminService.getNumOfAppliedStudents(programme);
//
//
//    }
//
//
//}
