package com.karma.workhistory.service.util;
/*
 * Class for RequestStatus
 */
public enum RequestStatus {

	Created("CREATED"),Submitted("SUBMITTED"),Review("REVIEW"),Accepted("ACCEPTED"),Rejected("REJECTED");
	
	String status;
	
	RequestStatus(String status){
		this.status = status;
	}
	
}
