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
import com.karma.workhistory.service.util.UserType;

@Controller
public class LoginController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/submitLoginDetails", method = RequestMethod.POST)
	public ModelAndView submitLogin(@RequestParam("userName") String userName,
			@RequestParam("password") String password, HttpServletRequest request) {

		ModelAndView model = new ModelAndView();
		User user = userService.isValidUser(userName, password);
		if (user != null) {
		    UserType userType = UserType.valueOf(user.getUserType());
		    switch(userType){
		    case Candidate:
			model.setViewName("fillInCandidateDetails");
			model.addObject("message", "Login Successful for UserType Candidate");
			request.getSession().setAttribute("LOGGEDIN_USER", user);
			break;

		    case HR :
			model.setViewName("addCandidate");
			model.addObject("message", "Login Successful for UserType HR");
			request.getSession().setAttribute("LOGGEDIN_USER", user);
			break;
			
		    case Admin:
			break;
			
		    default:
			break;
		    }
		}
			
		return model;
	}

	@RequestMapping(value = "/login")
	public String printWelcome(ModelMap model) {
            return "login";
	}
}
