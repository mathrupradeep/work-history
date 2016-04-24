package com.karma.workhistory.service.util;
/*
 * Class for UserTypes
 */
public enum UserType {

	Admin("admin"),HR("hr"),Candidate("candidate");
	
	String userType;
	
	UserType(String userType){
		this.userType = userType;
	}
	
}
