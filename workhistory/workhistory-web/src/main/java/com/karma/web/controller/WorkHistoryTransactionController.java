package com.karma.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.karma.workhistory.model.Company;
import com.karma.workhistory.model.User;
import com.karma.workhistory.model.WorkHistoryTransaction;
import com.karma.workhistory.service.RequestQueueService;
import com.karma.workhistory.service.WorkHistoryTransactionService;
import com.karma.workhistory.service.util.RequestStatus;
import com.karma.workhistory.service.util.TransactionStatus;

@Controller
public class WorkHistoryTransactionController {

	@Autowired
	RequestQueueService requestQueueService;
	
	@Autowired
	WorkHistoryTransactionService workHistoryTransactionService;
	
	@RequestMapping("listTransactionsForAction")
	public ModelAndView getList(HttpServletRequest request){
		
		User userData = (User) request.getSession().getAttribute("LOGGEDIN_USER");
		Company company = userData.getCompany();
		List<WorkHistoryTransaction> transactionList = workHistoryTransactionService.getWorkHistoryTransactinOnStatus("Pending",company);
		ModelAndView model = new ModelAndView();
		model.setViewName("transactionsListForAction");
		model.addObject("lists", transactionList);
		return model;
	}
	
	@RequestMapping("submitApprovedTransaction")
	public ModelAndView submitApprovedTransaction(HttpServletRequest request,@RequestParam Long[] transactionIds,@RequestParam Long[] requestQueueIds){

		for( int i = 0; i < requestQueueIds.length; i++)
		{
		    Long requestQueueId = requestQueueIds[i];
		    Long transactionId = transactionIds[i];
		    User companyUser = (User) request.getSession().getAttribute("LOGGEDIN_USER");
		    workHistoryTransactionService.updateTransactionStatusOnId(TransactionStatus.valueOf("Approved").toString(),transactionId,companyUser);
		    requestQueueService.updateStatusOnId(requestQueueId,RequestStatus.valueOf("Completed").toString());

		}
	
		ModelAndView model = new ModelAndView();
		model.setViewName("Dashboard");
		model.addObject("lists", null);
		return model;
	}
	
	@RequestMapping("submitRejectedTransaction")
	public ModelAndView submitRejectedTransaction(HttpServletRequest request,@RequestParam Long[] transactionIds,@RequestParam Long[] requestQueueIds){

		for( int i = 0; i < requestQueueIds.length; i++)
		{
		    Long requestQueueId = requestQueueIds[i];
		    Long transactionId = transactionIds[i];
		    User companyUser = (User) request.getSession().getAttribute("LOGGEDIN_USER");
		    workHistoryTransactionService.updateTransactionStatusOnId(TransactionStatus.valueOf("Rejected").toString(),transactionId,companyUser);
		    requestQueueService.updateStatusOnId(requestQueueId,RequestStatus.valueOf("Completed").toString());

		}
	
		ModelAndView model = new ModelAndView();
		model.setViewName("Dashboard");
		model.addObject("lists", null);
		return model;
	}
	
	@RequestMapping("listTransactions")
	public ModelAndView getWorkHistoryTransactinOnCompany(HttpServletRequest request){
		
		User userData = (User) request.getSession().getAttribute("LOGGEDIN_USER");
		Company company = userData.getCompany();
		List<WorkHistoryTransaction> transactionList = workHistoryTransactionService.getWorkHistoryTransactinofCompany(null,company);
		ModelAndView model = new ModelAndView();
		model.setViewName("transactionsList");
		model.addObject("lists", transactionList);
		return model;
	}
	
	@RequestMapping("listAllApprovedTransactions")
	public ModelAndView getAllApprovedTransactionsOnCompany(HttpServletRequest request){
		
		User userData = (User) request.getSession().getAttribute("LOGGEDIN_USER");
		Company company = userData.getCompany();
		List<WorkHistoryTransaction> transactionList = workHistoryTransactionService.getWorkHistoryTransactinofCompany(TransactionStatus.valueOf("Approved").toString(),company);
		ModelAndView model = new ModelAndView();
		model.setViewName("transactionsList");
		model.addObject("lists", transactionList);
		return model;
	}
	
	@RequestMapping("listAllRejectedTransactions")
	public ModelAndView getAllRejectedTransactionsOnCompany(HttpServletRequest request){
		
		User userData = (User) request.getSession().getAttribute("LOGGEDIN_USER");
		Company company = userData.getCompany();
		List<WorkHistoryTransaction> transactionList = workHistoryTransactionService.getWorkHistoryTransactinofCompany(TransactionStatus.valueOf("Rejected").toString(),company);
		ModelAndView model = new ModelAndView();
		model.setViewName("transactionsList");
		model.addObject("lists", transactionList);
		return model;
	}
}
