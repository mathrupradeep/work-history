package com.karma.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.karma.workhistory.model.Company;
import com.karma.workhistory.model.RequestQueue;
import com.karma.workhistory.model.User;
import com.karma.workhistory.service.CompanyService;
import com.karma.workhistory.service.RequestQueueService;
import com.karma.workhistory.service.UserService;
import com.karma.workhistory.service.util.UserType;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private RequestQueueService requestQueueService;
	
	@Autowired
	private DashboardController dashboardController;
		

	@RequestMapping(value = "/submitLoginDetails", method = RequestMethod.POST)
	public ModelAndView submitLogin(@RequestParam("userName") String userName,
			@RequestParam("password") String password, HttpServletRequest request) {

		ModelAndView model = new ModelAndView();
		User user = userService.isValidUser(userName, password);
		if (user != null) {
		    UserType userType = UserType.valueOf(user.getUserType());
		    switch(userType){
		    case Candidate:
			request.getSession().setAttribute("LOGGEDIN_USER", user);
			//User LoggedInCandidateUser = (User) request.getSession().getAttribute("LOGGEDIN_USER");
			List<Company> companies = companyService.getCompanyList();
			Company company = user.getCompany();
			companies.remove(company);
			model.addObject("CandidateCompany", companies);
			/* display details of the candidates who's details are already entered into the DB,
			Based on Candidate ID*/
			List<RequestQueue> listOfCandidateIds = requestQueueService.getCandIdInRequestQueue(user.getId());
			
			if(listOfCandidateIds != null && listOfCandidateIds.size()>0){
			    model.setViewName("displayExistingCandDetails");
			    model.addObject("existingCandEmpDetails", listOfCandidateIds.get(0));
			    model.addObject("existingCandDetails", user);
			    break;
			}
			model.setViewName("CandidateDetails");
			model.addObject("message", "Login Successful for UserType Candidate");
			break;

		    case HR :
		    List<Integer> queueAndTransactionSize = dashboardController.getQueueAndTransactionSize(user, user.getCompany());
			model.setViewName("Dashboard");
			model.addObject("firstName", user.getFirstName());
			model.addObject("queueSize",queueAndTransactionSize.get(0));
			model.addObject("transactionListSize",queueAndTransactionSize.get(1));
			request.getSession().setAttribute("LOGGEDIN_USER", user);
			break;
			
		    case Admin:
			break;
			
		    default:
			break;
		    }
		}
		else{
		    model.setViewName("login");
		}
			
		return model;
	}

	@RequestMapping(value = "/login")
	public String printWelcome(ModelMap model) {
            return "login";
	}

	public DashboardController getDashboardController() {
		return dashboardController;
	}

	public void setDashboardController(DashboardController dashboardController) {
		this.dashboardController = dashboardController;
	}
}
