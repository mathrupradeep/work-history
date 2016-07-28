package com.karma.workhistory.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.genericdao.search.Search;
import com.karma.workhistory.dao.HibernateUtil;
import com.karma.workhistory.model.Company;
import com.karma.workhistory.model.RequestQueue;

@Service("requestQueueService")
public class RequestQueueService {

    @Autowired
    private HibernateUtil<RequestQueue, RequestQueue> hibernateUtil;
    
    @Autowired
    private UserService userService;

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

	return result;
    }

    
    public List<RequestQueue> getRequestQueueOnStatus(String status,Company company){
    	
		Search serachCriteria = new Search(RequestQueue.class);
		serachCriteria.addFilterEqual("requestStatus", status);
		List<RequestQueue> queuelist = hibernateUtil.search(serachCriteria);
		List<RequestQueue> otherCompanyQueues = new ArrayList<RequestQueue>();
		
		for(RequestQueue request:queuelist){
			Company requestCompany = null;
			requestCompany = userService.getUserByEmailID(request.getUser().getEmailId()).getCompany();
			if(requestCompany.getId()!=company.getId()){
				otherCompanyQueues.add(request);
			}
		}
		queuelist.removeAll(otherCompanyQueues);
		return queuelist;
    }
    
    public RequestQueue getRequestQueueOnId(int id){
		Search serachCriteria = new Search(RequestQueue.class);
		serachCriteria.addFilterEqual("id", id);
		RequestQueue requestQueue = (RequestQueue) hibernateUtil.searchUnique(serachCriteria);
    	return requestQueue;
    }


	public void updateStatusOnId(int requestQueueId, String status) {
		RequestQueue requestQueue = getRequestQueueOnId(requestQueueId);
		requestQueue.setChangeDate(new Date());
		requestQueue.setRequestStatus(status);
		hibernateUtil.update(RequestQueue.class, requestQueue);
	}
}
