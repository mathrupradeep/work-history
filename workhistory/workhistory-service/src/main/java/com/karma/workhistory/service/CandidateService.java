package com.karma.workhistory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karma.workhistory.model.User;
import com.karma.workhistory.service.util.RandomPasswordGenerator;
import com.karma.workhistory.service.util.UserType;

@Service("candidateService")
public class CandidateService {

	@Autowired
	UserService userService;

	public String addCandidate(User candidate) {
		candidate.setPassword(RandomPasswordGenerator.getRandomPassword(9));
		candidate.setUserType(UserType.valueOf("Candidate").toString());
		return userService.addUser(candidate);
	}
}
