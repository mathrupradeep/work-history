package com.karma.workhistory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.karma.workhistory.dao.HibernateUtil;
import com.karma.workhistory.model.RequestQueue;
import com.karma.workhistory.model.User;

@Service("requestQueueService")
public class RequestQueueService {

    @Autowired
    private HibernateUtil<RequestQueue, RequestQueue> hibernateUtil;

    @Transactional
    public String addCandidateEmploymentDetails(RequestQueue candidateEmpDetails) {
	boolean valid = true;
	String result = null;
	if (valid) {
	    try {
		hibernateUtil.save(RequestQueue.class, candidateEmpDetails);
	    } catch (Exception e) {
		e.printStackTrace();
		result = e.getMessage();
	    }

	}
	/* } */
	return result;
    }

}
