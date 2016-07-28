package com.karma.workhistory.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.karma.workhistory.dao.HibernateUtil;
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
	public void createTransaction(int requestQueueId,User companyUser){
		 WorkHistoryTransaction transaction = new WorkHistoryTransaction();
		 transaction.setStatus(TransactionStatus.valueOf("Created").toString());
		 transaction.setCreatedDate(new Date());
		 transaction.setChangeDate(new Date());
		 RequestQueue requestQueue = requestQueueService.getRequestQueueOnId(requestQueueId);
		 transaction.setRequestQueue(requestQueue);
		 transaction.setRequestorCompanyHr(companyUser);
		 hibernateUtil.save(transaction);

	}
}
