package com.karma.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.karma.workhistory.service.CandidateService;

@Controller
public class DashboardController {

    @Autowired
    private CandidateService candiateService;

    @RequestMapping(value = "/Dashboard")
    public ModelAndView displayDashboard() {

	ModelAndView model = new ModelAndView();
	model.setViewName("Dashboard");
	return model;
    }
}
