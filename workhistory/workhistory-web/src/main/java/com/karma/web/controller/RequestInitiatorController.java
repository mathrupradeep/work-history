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
import com.karma.workhistory.model.WorkHistoryTransaction;
import com.karma.workhistory.service.RequestQueueService;
import com.karma.workhistory.service.WorkHistoryTransactionService;

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
		List<RequestQueue> queueList = requestQueueService.getRequestQueueOnStatusa("Created",company);
		ModelAndView model = new ModelAndView();
		model.setViewName("InitiateRequest");
		model.addObject("lists", queueList);
		return model;
	}
	
	@RequestMapping("submitrequestInitator")
	public ModelAndView submitrequestInitator(@RequestParam String[] candidateIds){

		for( int i = 0; i < candidateIds.length - 1; i++)
		{
		    int candidateId = Integer.parseInt(candidateIds[i]);
		    WorkHistoryTransaction transaction = new WorkHistoryTransaction();
		    workHistoryTransactionService.persistTransaction(transaction, candidateId);

		}
	
		ModelAndView model = new ModelAndView();
		model.setViewName("InitiateRequest");
		model.addObject("lists", null);
		return model;
	}
}
