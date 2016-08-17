package com.karma.workhistory.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.karma.workhistory.dao.HibernateUtil;
import com.karma.workhistory.model.Company;
import com.karma.workhistory.model.RequestQueue;
import com.karma.workhistory.model.User;
import com.karma.workhistory.model.WorkHistoryTransaction;
import com.karma.workhistory.service.util.TransactionStatus;


@Service("workHistoryTransactionService")
public class WorkHistoryTransactionService {

	@Autowired
	private HibernateUtil<WorkHistoryTransaction, WorkHistoryTransaction> hibernateUtil;
	
	@Autowired
	private RequestQueueService requestQueueService;
	
	
	
	@Transactional
	public void createTransaction(Long requestQueueId,User companyUser){
		 WorkHistoryTransaction transaction = new WorkHistoryTransaction();
		 transaction.setStatus(TransactionStatus.valueOf("Pending").toString());
		 transaction.setCreatedDate(new Date());
		 transaction.setChangeDate(new Date());
		 RequestQueue requestQueue = requestQueueService.getRequestQueueOnId(requestQueueId);
		 transaction.setRequestQueue(requestQueue);
		 transaction.setRequestorCompanyHr(companyUser);
		 hibernateUtil.save(transaction);

	}
	
	 public List<WorkHistoryTransaction> getWorkHistoryTransactinOnStatus(String status,Company company){

		    String hqlQuery ="FROM WorkHistoryTransaction wht where wht.status='"+status+"' and wht.requestQueue IN (FROM RequestQueue RQ where RQ.approverCompany.id="+company.getId()+")";
			List<WorkHistoryTransaction> queuelist = hibernateUtil.getListByHQLQuery(WorkHistoryTransaction.class, hqlQuery);
			return queuelist;
	    }

	public WorkHistoryTransaction updateTransactionStatusOnId(String status, Long transactionId, User companyUser) {
		WorkHistoryTransaction workHistoryTransaction = hibernateUtil.find(WorkHistoryTransaction.class,transactionId);
		workHistoryTransaction.setStatus(status);
		workHistoryTransaction.setApproverCompanyHr(companyUser);
		workHistoryTransaction.setChangeDate(new Date());
		hibernateUtil.update(WorkHistoryTransaction.class, workHistoryTransaction);
		return workHistoryTransaction;
		
	}
	
	 public List<WorkHistoryTransaction> getWorkHistoryTransactinofCompany(String status,Company company){

		    String hqlQuery = null;
		 
		    if(status==null){
		    		hqlQuery ="FROM WorkHistoryTransaction wht where wht.requestQueue IN (FROM RequestQueue RQ where RQ.user.company.id="+company.getId()+")";
		    }
		    else{
		    	hqlQuery ="FROM WorkHistoryTransaction wht where wht.status='"+status+"' and wht.requestQueue IN (FROM RequestQueue RQ where RQ.user.company.id="+company.getId()+")";
		    }
			List<WorkHistoryTransaction> queuelist = hibernateUtil.getListByHQLQuery(WorkHistoryTransaction.class, hqlQuery);
			return queuelist;
	    }
}
