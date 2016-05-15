package com.karma.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.karma.workhistory.service.UserService;

@Controller
public class LogoutController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		model.addObject("message", "Logout Successful");
		request.getSession().invalidate();
		return model;

	}
}
