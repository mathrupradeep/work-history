package com.karma.workhistory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.genericdao.search.Search;
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
	
	@Transactional
	public Company getCompanyByID(Long id){
	    
	    Search serachCriteria = new Search(Company.class);
		serachCriteria.addFilterEqual("id", id);
		Company object=null;
		try{
		object = (Company) hibernateUtil.searchUnique(serachCriteria);
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		return object;
	}

}
