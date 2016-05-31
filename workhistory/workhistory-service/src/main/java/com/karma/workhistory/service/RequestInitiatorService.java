package com.karma.workhistory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.googlecode.genericdao.search.Search;
import com.karma.workhistory.dao.HibernateUtil;
import com.karma.workhistory.model.RequestInitiator;
import com.karma.workhistory.model.User;
import com.karma.workhistory.service.util.RandomPasswordGenerator;
import com.karma.workhistory.service.util.UserType;


@Service("requestInitiatorService")
public class RequestInitiatorService {

    @Autowired
    private HibernateUtil<RequestInitiator, RequestInitiator> hibernateUtil;


    public String requestInitiator(RequestInitiator requestInitiator) {
	// TODO Auto-generated method stub
	return addRequestInitiatorDetails(requestInitiator);
    
    }

    private String addRequestInitiatorDetails(RequestInitiator requestInitiator) {
	// TODO Auto-generated method stub
	String result = null;
		try {
			hibernateUtil.save(RequestInitiator.class, requestInitiator);
		} catch (Exception e) {
			System.out.println("Exception from persist or update ");
			e.printStackTrace();
			result = e.getMessage();
		}
	
	return result;
    }

}
