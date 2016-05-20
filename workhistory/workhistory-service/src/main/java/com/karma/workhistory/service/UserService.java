package com.karma.workhistory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.genericdao.search.Search;
import com.karma.workhistory.dao.HibernateUtil;
import com.karma.workhistory.model.RequestQueue;
import com.karma.workhistory.model.User;
import com.karma.workhistory.service.util.EmailValidator;
import com.karma.workhistory.service.util.RandomPasswordGenerator;

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
		if (user.getPassword().isEmpty() || user.getPassword().length() < 8 || user.getUserType().isEmpty()) {
			valid = false;
		}
		if (!EmailValidator.validate(user.getEmailId())) {
			valid = false;
		}
		if (valid) {
			Search serachCriteria = new Search(User.class);
			serachCriteria.addFilterEqual("emailId", user.getEmailId());
			serachCriteria.addFilterEqual("phoneNumber", user.getPhoneNumber());
			hibernateUtil.setSessionFactory(hibernateUtil.getsessionFactory());
			User object = (User) hibernateUtil.searchUnique(serachCriteria);
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
		boolean valid = true;
		String result = null;
		if (valid) {
			try {
				hibernateUtil.save(User.class, user);
			} catch (Exception e) {
				System.out.println("Exception from persist or update ");
				e.printStackTrace();
				result = e.getMessage();
			}

		}
		/* } */
		return result;
	}

	public User isValidUser(String userName, String password) {

		Search serachCriteria = new Search(User.class);
		serachCriteria.addFilterEqual("emailId", userName);
		hibernateUtil.setSessionFactory(hibernateUtil.getsessionFactory());
		User user = (User) hibernateUtil.searchUnique(serachCriteria);

		if (!(user != null && RandomPasswordGenerator.generateHash(password).equalsIgnoreCase(user.getPassword())))
			user = null;

		return user;
	}
}