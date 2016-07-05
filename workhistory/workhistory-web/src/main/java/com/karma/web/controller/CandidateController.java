package com.karma.web.controller;

import java.io.File;
import java.util.Date;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.karma.workhistory.model.RequestInitiator;
import com.karma.workhistory.model.RequestQueue;
import com.karma.workhistory.model.User;
import com.karma.workhistory.service.CandidateService;
import com.karma.workhistory.service.RequestInitiatorService;
import com.karma.workhistory.service.UserService;
import com.karma.workhistory.service.util.RequestStatus;
import com.karma.workhistory.service.util.SendEmail;

@Controller
public class CandidateController {

	@Autowired
	private CandidateService candiateService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RequestInitiatorService requestInitiatorService;

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
		RequestInitiator requestInitiator = new RequestInitiator();
		SendEmail sendEmail = new SendEmail();
		candidate.setEmailId(mailId);
		candidate.setPhoneNumber(phoneNumber);
		candidate.setCompany(userService.getUserByEmailID("vikramk.cs@gmail.com").getCompany());
		
		requestInitiator.setCompany(userService.getUserByEmailID("vikramk.cs@gmail.com").getCompany());
		
		String message = candiateService.addCandidate(candidate);
		requestInitiator.setCandidateId(userService.getUserByEmailID(mailId));
		requestInitiator.setHrId(userService.getUserByEmailID("vikramk.cs@gmail.com"));
		String processInitiated = requestInitiatorService.requestInitiator(requestInitiator);
		System.out.println("processInitiated = "+processInitiated);
		if (message == null){
			message = "Candidate Added Sucessfully & Email will be sent";
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

	    	//hard code email id and phone number for the logged in candidate
		ModelAndView model = new ModelAndView();
		model.setViewName("CandidateDetails");
		return model;
	}

	@RequestMapping(value = "/submitCandidateDetails")
	public ModelAndView submitCandidateDetails(
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("DOB") Date DOB,
			@RequestParam("mostRecentEmployer") String mostRecentEmployer,
			@RequestParam("employeeId") String employeeId,
			@RequestParam("joiningDate") Date joiningDate,
			@RequestParam("relievingDate") Date relievingDate,
			@RequestParam("relievingLetterPDF") File relievingLetterPDF,
			HttpServletRequest request) {

		ModelAndView model = new ModelAndView();
		System.out.println(firstName +" "+ lastName );
		User candidate = (User) request.getSession().getAttribute("LOGGEDIN_USER");
		RequestQueue candidateEmpDetails = new RequestQueue();
		candidate.setFirstName(firstName);
		candidate.setLastName(lastName);
		candidate.setBirthDate(DOB);
		
		candidateEmpDetails.setEmployeeId(employeeId);
		candidateEmpDetails.setMostRecentEmployer(mostRecentEmployer); 
		candidateEmpDetails.setJoiningDate(joiningDate);
		candidateEmpDetails.setRelievingDate(relievingDate);
		candidateEmpDetails.setRelievingLetterPDF(relievingLetterPDF);
		candidateEmpDetails.setRequestStatus(RequestStatus.valueOf("Created").toString());
		candidateEmpDetails.setUser(candidate);
		
		String decidecandidateEmpDetails = candiateService.addCandidateEmploymentDetails(candidateEmpDetails);
		String successOrFailure = candiateService.addCandidateDetails(candidate);
		
		
		if (successOrFailure == null && decidecandidateEmpDetails == null)
			successOrFailure = "Candidate Details Added Sucessfully";
		else
			successOrFailure = "Error adding candidate Details";
		model.addObject("msg", successOrFailure);
		model.setViewName("CandidateDetails");
		return model;

	}
}
