package com.karma.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.karma.workhistory.model.Company;
import com.karma.workhistory.model.User;
import com.karma.workhistory.service.RequestQueueService;
import com.karma.workhistory.service.WorkHistoryTransactionService;

@Controller
public class DashboardController {
	
	
	@Autowired
	RequestQueueService requestQueueService;
	
	@Autowired
	WorkHistoryTransactionService workHistoryTransactionService;

    @RequestMapping(value = "/Dashboard")
    public ModelAndView displayDashboard(HttpServletRequest request) {
    	
	User userData = (User) request.getSession().getAttribute("LOGGEDIN_USER");
	Company company = userData.getCompany();
	List<Integer> queueAndTransactionSize = getQueueAndTransactionSize(userData,company);
	
	int queueSize = (Integer) queueAndTransactionSize.get(0);
	int transactionListSize = (Integer) queueAndTransactionSize.get(1);

	ModelAndView model = new ModelAndView();
	model.addObject("queueSize",queueSize);
	model.addObject("transactionListSize",transactionListSize);
	model.setViewName("Dashboard");
	return model;
    }
    
    public List<Integer> getQueueAndTransactionSize(User userData,Company company){
    	
    	int queueSize = requestQueueService.getRequestQueueOnStatus("Created",company).size();
    	int transactionListSize = workHistoryTransactionService.getWorkHistoryTransactinOnStatus("Pending",company).size();
    	
    	List<Integer> queueAndTransactionSize = new ArrayList<Integer>();
    	
    	queueAndTransactionSize.add(queueSize);
    	queueAndTransactionSize.add(transactionListSize);
    	
    	return queueAndTransactionSize;
    }
}
