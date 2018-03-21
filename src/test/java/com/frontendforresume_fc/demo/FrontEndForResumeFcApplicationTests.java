package com.frontendforresume_fc.demo;

import com.frontendforresume_fc.demo.model.Programme;
import com.frontendforresume_fc.demo.model.Requirement;
import com.frontendforresume_fc.demo.model.User;
import com.frontendforresume_fc.demo.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FrontEndForResumeFcApplicationTests {
	@Autowired
	UserService userService;

	@Autowired
	ProgrammeService programmeService;

	@Autowired
	StudentService studentService;

	@Autowired
	RequirementService requirementService;

	@Autowired
	AdminService adminService;

	@Test
	public void contextLoads() {
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


	}

}
