package com.frontendforresume_fc.demo;

import com.frontendforresume_fc.demo.model.User;
import com.frontendforresume_fc.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FrontEndForResumeFcApplicationTests {
	@Autowired
	UserService userService;

	@Test
	public void contextLoads() {
		User student = new User();
		student.setFirstName("Harry");
		student.setLastName("Um");
		userService.saveNewUser(student);
	
	}

}
