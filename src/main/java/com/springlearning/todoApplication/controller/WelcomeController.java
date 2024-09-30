package com.springlearning.todoApplication.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class WelcomeController {

    @RequestMapping("/")
    public String welcome(ModelMap model){
        model.put("username",getLoggedInUser());
        return "welcome";
    }
    private String getLoggedInUser() {
    	return SecurityContextHolder.getContext().getAuthentication().getName();
    }

}
