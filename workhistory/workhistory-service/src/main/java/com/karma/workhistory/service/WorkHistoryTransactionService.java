package com.karma.workhistory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.karma.workhistory.dao.HibernateUtil;
import com.karma.workhistory.model.WorkHistoryTransaction;


@Service("workHistoryTransactionService")
public class WorkHistoryTransactionService {

	@Autowired
	private HibernateUtil<WorkHistoryTransaction, WorkHistoryTransaction> hibernateUtil;
	
	@Transactional
	public void persistTransaction(WorkHistoryTransaction item,int requestQueueId){
		
	}
}
