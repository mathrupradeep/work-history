package com.karma.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.karma.workhistory.model.User;
import com.karma.workhistory.service.CandidateService;

@Controller
public class CandidateController {

	@Autowired
	private CandidateService candiateService;
	
	
	 @RequestMapping(value = "/addCandidate")
	    public ModelAndView getAddCandidate() {

	            ModelAndView model = new ModelAndView();
	            model.setViewName("addCandidate");
	            return model;
	    }

	 
	 @RequestMapping(value = "/submitCandidateDetails")
	    public ModelAndView submitCandidateDetails(@RequestParam("mailId") String mailId,@RequestParam("phoneNumber") String phoneNumber ) {

	            ModelAndView model = new ModelAndView();
	            User candidate = new User();
	            candidate.setEmailId(mailId);
	            candidate.setPhoneNumber(phoneNumber);
	            String message = candiateService.addCandidate(candidate);
	            if(message.isEmpty())
	            	message= "Candidate Added Sucessfully";
	            else
	            	message = "Error adding candidate";
	            model.addObject("msg", message);
	            model.setViewName("addCandidate");
	            return model;


	    }
}
