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
			if(request.getUser().getCompany().getId()!=company.getId()){
				otherCompanyQueues.add(request);
			}
		}
		queuelist.removeAll(otherCompanyQueues);
		return queuelist;
    }
    
    public RequestQueue getRequestQueueOnId(Long id){
    	return hibernateUtil.find(RequestQueue.class,id);
    }


	public void updateStatusOnId(Long requestQueueId, String status) {
		RequestQueue requestQueue = getRequestQueueOnId(requestQueueId);
		requestQueue.setChangeDate(new Date());
		requestQueue.setRequestStatus(status);
		hibernateUtil.update(RequestQueue.class, requestQueue);
	}
	
	public List<RequestQueue> getCandIdInRequestQueue(Long userId) {
	    String sqlQuery ="select workhistory.request_queue.candidate_id from workhistory.request_queue where workhistory.request_queue.candidate_id =" +userId;
	    String hqlQuery  = "from RequestQueue where user.id ="+ userId;
	    /*Query query = session.createQuery(hql);
	    query.setDouble("userId",userId);
	    List results = query.list();*/
	    return hibernateUtil.getListByHQLQuery(RequestQueue.class, hqlQuery);
	}
}
