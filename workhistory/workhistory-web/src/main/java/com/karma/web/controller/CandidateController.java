package com.karma.web.controller;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.karma.workhistory.model.Company;
import com.karma.workhistory.model.RequestInitiator;
import com.karma.workhistory.model.RequestQueue;
import com.karma.workhistory.model.User;
import com.karma.workhistory.service.CandidateService;
import com.karma.workhistory.service.CompanyService;
import com.karma.workhistory.service.RequestInitiatorService;
import com.karma.workhistory.service.UserService;
import com.karma.workhistory.service.util.RequestStatus;
import com.karma.workhistory.service.util.SendEmail;

@Controller
public class CandidateController {

	@Autowired
	private CandidateService candiateService;

	@Autowired
	private CompanyService companyService;
	
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
			@RequestParam("phoneNumber") String phoneNumber,HttpServletRequest request) throws AddressException, MessagingException {

		ModelAndView model = new ModelAndView();
		User hr = (User) request.getSession().getAttribute("LOGGEDIN_USER");
		String hrMailId = hr.getEmailId();
		User candidate = new User();
		RequestInitiator requestInitiator = new RequestInitiator();
		SendEmail sendEmail = new SendEmail();
		candidate.setEmailId(mailId);
		candidate.setPhoneNumber(phoneNumber);
		candidate.setCompany(userService.getUserByEmailID(hrMailId).getCompany());
		
		requestInitiator.setCompany(userService.getUserByEmailID(hrMailId).getCompany());
		
		String message = candiateService.addCandidate(candidate);
		requestInitiator.setCandidateId(userService.getUserByEmailID(mailId));
		requestInitiator.setHrId(userService.getUserByEmailID(hrMailId));
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
	public ModelAndView fillInCandidateDetails(HttpServletRequest request) {

	    	//hard code email id and phone number for the logged in candidate
		ModelAndView model = new ModelAndView();
		model.setViewName("CandidateDetails");
		User LoggedInCandidateUser = (User) request.getSession().getAttribute("LOGGEDIN_USER");
		List<Company> companies = companyService.getCompanyList();
		companies.remove(LoggedInCandidateUser.getCompany());
		model.addObject("CandidateCompany", companies);
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
			@RequestParam("designation") String designation,
			@RequestParam("CTC") Long CTC,
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
		candidateEmpDetails.setJoiningDate(joiningDate);
		candidateEmpDetails.setRelievingDate(relievingDate);
		candidateEmpDetails.setSalary(CTC);
		candidateEmpDetails.setDesignation(designation);
		candidateEmpDetails.setRelievingLetterPDF(relievingLetterPDF);
		candidateEmpDetails.setRequestStatus(RequestStatus.valueOf("Created").toString());
		candidateEmpDetails.setUser(candidate);
		candidateEmpDetails.setCreatedDate(new Date());
		
		String successOrFailure = candiateService.addCandidateDetails(candidate);
		String decidecandidateEmpDetails = candiateService.addCandidateEmploymentDetails(candidateEmpDetails); 
		
		if (successOrFailure == null && decidecandidateEmpDetails == null){
		    successOrFailure = "Candidate Details Added Sucessfully";
		}
			
		else
			successOrFailure = "Error adding candidate Details";
		
		model.addObject("msg", successOrFailure);
		model.setViewName("displayCandidateDetails");
		model.addObject("dispCandEmpDetails", candidateEmpDetails);
		model.addObject("dispCandDetails", candidate);
		return model;

	}
}
