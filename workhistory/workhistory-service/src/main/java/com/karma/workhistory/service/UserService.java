package com.karma.workhistory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.karma.workhistory.dao.HibernateUtil;
import com.karma.workhistory.model.User;
import com.karma.workhistory.service.util.EmailValidator;

@Service("candidateService")
public class UserService {
	
	@Autowired
	private HibernateUtil<User, User> hibernateUtil;
	
	@Transactional
	public boolean addUser(User user){
		//validate the fields in user
		boolean valid= true;
		if(user.getPassword().isEmpty() || user.getPassword().length()<8 || user.getFirstName().isEmpty() || user.getLastName().isEmpty() || user.getBirthDate() == null || user.getUserType().isEmpty())
				valid = false;
		if(!EmailValidator.validate(user.getEmailId()))
				valid = false;
			
		if(valid)
			hibernateUtil.persistSaveOrUpdate(User.class, user);
		return true;
	}
	

}
