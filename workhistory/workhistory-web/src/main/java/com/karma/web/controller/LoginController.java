package com.karma.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.karma.workhistory.model.User;
import com.karma.workhistory.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	UserService userService;
    
    @RequestMapping(value = "/submitLoginDetails", method = RequestMethod.POST)
    public ModelAndView submitLogin(@RequestParam("userName") String userName,@RequestParam("password") String password,HttpServletRequest request ) {

            ModelAndView model = new ModelAndView();
            User user = userService.isValidUser(userName, password);
            if(user != null){
            	model.setViewName("login");
            	model.addObject("message", "Login Successful");
            	request.getSession().setAttribute("LOGGEDIN_USER", user);
            }
            else{
            	model.setViewName("login");
            	model.addObject("message", "Not a valid User");
            }
            return model;


    }
    
    @RequestMapping(value = "/login")
    public String printWelcome(ModelMap model) {
            return "login";

    }
}
