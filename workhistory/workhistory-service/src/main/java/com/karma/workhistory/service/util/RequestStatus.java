package com.karma.workhistory.service.util;
/*
 * Class for RequestStatus
 */
public enum RequestStatus {

	Created("CREATED"),Initiated("INITIATED"),Completed("COMPLETED");
	
	String status;
	
	RequestStatus(String status){
		this.status = status;
	}
	
}
