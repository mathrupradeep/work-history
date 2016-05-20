package com.karma.web.controller;

import java.io.File;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.karma.workhistory.model.RequestQueue;
import com.karma.workhistory.model.User;
import com.karma.workhistory.service.CandidateService;
import com.karma.workhistory.service.util.SendEmail;

@Controller
@Configuration
@ComponentScan("com.karma.workhistory.*")
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
	public ModelAndView submitCandidateBasicInfo(
			@RequestParam("mailId") String mailId,
			@RequestParam("phoneNumber") String phoneNumber) throws AddressException, MessagingException {

		ModelAndView model = new ModelAndView();
		System.out.println(mailId + phoneNumber);
		User candidate = new User();
		SendEmail sendEmail = new SendEmail();
		candidate.setEmailId(mailId);
		candidate.setPhoneNumber(phoneNumber);
		String message = candiateService.addCandidate(candidate);
		if (message == null){
			message = "Candidate Added Sucessfully";
			sendEmail.sendEmailFunction(candidate);
		}
		else
			message = "Error adding candidate";
		model.addObject("msg", message);
		model.setViewName("addCandidate");
		return model;

	}
	
	
	@RequestMapping(value = "/fillInCandidateDetails")
	public ModelAndView fillInCandidateDetails() {

		ModelAndView model = new ModelAndView();
		model.setViewName("CandidateDetails");
		return model;
	}

	@RequestMapping(value = "/submitCandidateDetails")
	public ModelAndView submitCandidateDetails(
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("DOB") Date DOB,
			@RequestParam("primaryPhoneNumber") String primaryPhoneNumber,
			@RequestParam("mostRecentEmployer") String mostRecentEmployer,
			@RequestParam("employeeId") String employeeId,
			@RequestParam("joiningDate") Date joiningDate,
			@RequestParam("relievingDate") Date relievingDate,
			@RequestParam("relievingLetterPDF") File relievingLetterPDF) {

		ModelAndView model = new ModelAndView();
		System.out.println(firstName +" "+ lastName +" "+ primaryPhoneNumber);
		User candidate = new User();
		RequestQueue candidateEmpDetails = new RequestQueue();
		candidate.setFirstName(firstName);
		candidate.setLastName(lastName);
		candidate.setBirthDate(DOB);
		candidate.setPhoneNumber(primaryPhoneNumber);
		
		candidateEmpDetails.setEmployeeId(employeeId);
		candidateEmpDetails.setMostRecentEmployer(mostRecentEmployer); 
		candidateEmpDetails.setJoiningDate(joiningDate);
		candidateEmpDetails.setRelievingDate(relievingDate);
		candidateEmpDetails.setRelievingLetterPDF(relievingLetterPDF);
		
		String successOrFailure = candiateService.addCandidateDetails(candidate);
		String decidecandidateEmpDetails = candiateService.addCandidateEmploymentDetails(candidateEmpDetails);
		if (successOrFailure == null && decidecandidateEmpDetails == null)
			successOrFailure = "Candidate Details Added Sucessfully";
		else
			successOrFailure = "Error adding candidate Details";
		model.addObject("msg", successOrFailure);
		model.setViewName("CandidateDetails");
		return model;

	}
}
