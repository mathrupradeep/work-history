package com.karma.workhistory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.karma.workhistory.dao.HibernateUtil;
import com.karma.workhistory.model.Transaction;


@Service("transactionService")
public class TransactionService {

	@Autowired
	private HibernateUtil<Transaction, Transaction> hibernateUtil;
	
	@Transactional
	public void persistTransaction(Transaction item){
		hibernateUtil.persistSaveOrUpdate(Transaction.class,item);
	}
}
