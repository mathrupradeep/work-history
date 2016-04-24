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

	 
	@RequestMapping(value = "/submitCandidateBasicInfo")
	    public ModelAndView submitCandidateBasicInfo(@RequestParam("mailId") String mailId,@RequestParam("phoneNumber") String phoneNumber ) {

	            ModelAndView model = new ModelAndView();
	            System.out.println(mailId + phoneNumber);
	            User candidate = new User();
	            candidate.setEmailId(mailId);
	            candidate.setPhoneNumber(phoneNumber);
	            String message = candiateService.addCandidate(candidate);
	            if(message == null )
	            	message= "Candidate Added Sucessfully";
	            else
	            	message = "Error adding candidate";
	            model.addObject("msg", message);
	            model.setViewName("addCandidate");
	            return model;

	    }
	 
	 @RequestMapping(value = "/submitCandidateDetails")
	    public ModelAndView submitCandidateDetails() {

	            ModelAndView model = new ModelAndView();
	           // System.out.println(mailId + phoneNumber);
	            model.setViewName("CandidateDetails");
	            return model;


	    }
}
