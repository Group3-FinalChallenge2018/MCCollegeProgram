//package com.frontendforresume_fc.demo;
//
//import com.frontendforresume_fc.demo.model.Programme;
//import com.frontendforresume_fc.demo.model.Requirement;
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
//	@Autowired
//	UserService userService;
//
//	@Autowired
//	ProgrammeService programmeService;
//
//	@Autowired
//	StudentService studentService;
//
//	@Autowired
//	RequirementService requirementService;
//
//	@Autowired
//	AdminService adminService;
//
//	@Test
//	public void compareUserProgramReq() {
//		User user = userService.findByUsername("clark");
//		Programme programme = programmeService.findByName("Promising the Future");
//
//		user.setStudentRequirements(new HashSet<>());
//		user.addRequirement(requirementService.createRequirement("Basic understanding of object oriented programming", true));
//		user.addRequirement(requirementService.createRequirement("Previous experience with an object-oriented language", true));
//		user.addRequirement(requirementService.createRequirement("Major in Computer Science / Information Systems", false));
//		user.addRequirement(requirementService.createRequirement("Graduated within the last 6 years", false));
//		user.addRequirement(requirementService.createRequirement("Currently earning 42,000 or less", false));
//		user.addRequirement(requirementService.createRequirement("Be able to work in the United States", true));
//
//		HashSet<Requirement> userEligibilty =  adminService.compareUserAndProgrammeRequirements(user, programme);
//	}
//
//	@Test
//    public void addOtherAdministrator(){
//        User admin = userService.findByUsername("admin2");
//        admin = new User("password", "admin3", "Rob", "Starrk", "rob@gmail.com");
//        userService.saveNewAdmin(admin);
//        Set<User> users = userService.findByAdmin();
//    }
//
//	@Test
//	public void baseCase(){
//		User clark = userService.findByUsername("clark");
//        User harry = userService.findByUsername("harry");
//        User tony = userService.findByUsername("tony");
//        User holy = userService.findByUsername("holy");
//        User hola = userService.findByUsername("hola");
//        User samsung = userService.findByUsername("samsung");
//        User yolo = userService.findByUsername("yolo");
//
//		User admin = userService.findByUsername("admin");
//		Programme programme = programmeService.findByName("Promising the Future");
//
//		studentService.apply2Programme(clark, programme);
//        studentService.apply2Programme(harry, programme);
//		studentService.apply2Programme(hola, programme);
//        studentService.apply2Programme(samsung, programme);
//        studentService.apply2Programme(yolo, programme);
//		HashSet<User> appliedStudentSet = adminService.getAppliedStudents(programme);
//		adminService.approveStudent2Programme(clark, programme);
//        adminService.approveStudent2Programme(harry, programme);
//        adminService.approveStudent2Programme(samsung, programme);
//        studentService.getApprovedProgramme(clark);
//        studentService.getApprovedProgramme(tony);
//        studentService.acceptProgramme(clark, programme);
//        studentService.acceptProgramme(harry, programme);
//        adminService.getNumOfAcceptedStudents(programme);
//        adminService.getNumOfAppliedStudents(programme);
//
//
//
//	}
//
//
//}
