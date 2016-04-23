package com.karma.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CandidateController {

	 @RequestMapping(value = "/addCandidate")
	    public ModelAndView getAddCandidate() {

	            ModelAndView model = new ModelAndView();
	            model.setViewName("addCandidate");
	            return model;


	    }

	 
	 @RequestMapping(value = "/submitCandidateDetails")
	    public ModelAndView submitCandidateDetails(@RequestParam("mailId") String mailId,@RequestParam("phoneNumber") String phoneNumber ) {

	            ModelAndView model = new ModelAndView();
	            System.out.println(mailId + phoneNumber);
	            model.setViewName(" ");
	            return model;


	    }
}
