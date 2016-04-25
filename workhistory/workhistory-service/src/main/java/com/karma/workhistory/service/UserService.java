package com.karma.workhistory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.genericdao.search.Search;
import com.karma.workhistory.dao.HibernateUtil;
import com.karma.workhistory.model.User;
import com.karma.workhistory.service.util.EmailValidator;

@Service("userService")
public class UserService {

	@Autowired
	private HibernateUtil<User, User> hibernateUtil;

	@Transactional
	public String addUser(User user) {
		// validate the fields in user
		boolean valid = true;
		String result = null;
		// if(user.getPassword().isEmpty() || user.getPassword().length()<8 ||
		// user.getFirstName().isEmpty() || user.getLastName().isEmpty() ||
		// user.getBirthDate() == null || user.getUserType().isEmpty())
		if (user.getPassword().isEmpty() || user.getPassword().length() < 8
				|| user.getUserType().isEmpty()) {
			valid = false;
		}
		if (!EmailValidator.validate(user.getEmailId())) {
			valid = false;
		}
			if (valid) {
				hibernateUtil.setSessionFactory(hibernateUtil.getsessionFactory());
				System.out.println(hibernateUtil.getsessionFactory());
				Search serachCriteria = new Search(User.class);
				serachCriteria.addFilterEqual("emailId", user.getEmailId());
				serachCriteria.addFilterEqual("phoneNumber",
						user.getPhoneNumber());

				List<User> object = hibernateUtil.search(serachCriteria);
				if (object == null) {
					try {
						hibernateUtil.save(User.class, user);
					} catch (Exception e) {
						e.printStackTrace();
						result = e.getMessage();
					}

				}
			}

		return result;
	}

	@Transactional
	public String addDetails(User user) {
		// TODO Auto-generated method stub
		boolean valid = true;
		String result = null;
		if (valid) {

		/*	Search serachCriteria = new Search(User.class);
			serachCriteria.addFilterEqual("firstName", user.getFirstName());
			serachCriteria.addFilterEqual("lastName", user.getLastName() );

			List<User> object = hibernateUtil.search(serachCriteria);
			if (object == null) {*/
				try {
					hibernateUtil.save(User.class, user);
				} catch (Exception e) {
					System.out.println("Exception from persist or update ");
					e.printStackTrace();
					result = e.getMessage();
				}

			}
		/*}*/
		return result;
	}

}
