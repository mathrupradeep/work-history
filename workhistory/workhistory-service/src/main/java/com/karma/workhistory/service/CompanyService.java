package com.karma.workhistory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karma.workhistory.dao.HibernateUtil;
import com.karma.workhistory.model.Company;
import com.karma.workhistory.model.RequestQueue;
import com.karma.workhistory.model.User;



@Service("companyService")
public class CompanyService{

    	@Autowired
    	private HibernateUtil<Company, Company> hibernateUtil;
    
	public List<Company> getCompanyList() {
		
		return hibernateUtil.findAll(Company.class);
	}
}
