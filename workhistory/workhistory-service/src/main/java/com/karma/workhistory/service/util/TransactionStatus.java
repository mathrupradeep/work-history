package com.karma.workhistory.service.util;
/*
 * Class for RequestStatus
 */
public enum TransactionStatus {

	Created("CREATED"),Approved("APPROVED"),Rejected("REJECTED");
	
	String status;
	
	TransactionStatus(String status){
		this.status = status;
	}
	
}
