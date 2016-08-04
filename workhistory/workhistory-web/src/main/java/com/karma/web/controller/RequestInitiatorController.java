package com.karma.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.karma.workhistory.model.Company;
import com.karma.workhistory.model.RequestQueue;
import com.karma.workhistory.model.User;
import com.karma.workhistory.service.RequestQueueService;
import com.karma.workhistory.service.WorkHistoryTransactionService;
import com.karma.workhistory.service.util.RequestStatus;

@Controller
public class RequestInitiatorController {
	
	@Autowired
	RequestQueueService requestQueueService;
	
	@Autowired
	WorkHistoryTransactionService workHistoryTransactionService;
	
	
	@RequestMapping("initiateRequest")
	public ModelAndView getList(HttpServletRequest request){
		
		User userData = (User) request.getSession().getAttribute("LOGGEDIN_USER");
		Company company = userData.getCompany();
		List<RequestQueue> queueList = requestQueueService.getRequestQueueOnStatus("Created",company);
		ModelAndView model = new ModelAndView();
		model.setViewName("InitiateRequest");
		model.addObject("lists", queueList);
		return model;
	}
	
	@RequestMapping("submitrequestInitator")
	public ModelAndView submitrequestInitator(HttpServletRequest request,@RequestParam Long[] requestQueueIds){

		for( int i = 0; i < requestQueueIds.length; i++)
		{
		    Long requestQueueId = requestQueueIds[i];
		    User companyUser = (User) request.getSession().getAttribute("LOGGEDIN_USER");
		    workHistoryTransactionService.createTransaction(requestQueueId,companyUser);
		    requestQueueService.updateStatusOnId(requestQueueId,RequestStatus.valueOf("Initiated").toString());

		}
	
		ModelAndView model = new ModelAndView();
		model.setViewName("Dashboard");
		model.addObject("lists", null);
		return model;
	}
}
