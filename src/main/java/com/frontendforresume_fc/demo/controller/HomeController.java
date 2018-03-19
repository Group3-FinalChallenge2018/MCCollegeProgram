package com.frontendforresume_fc.demo.controller;

import com.frontendforresume_fc.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String index() {
        return "html/index";
    }


    @RequestMapping("/all_users")
    public String viewAllUsers() {
        return "html/all_users";
    }


}
