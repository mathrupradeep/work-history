package com.karma.workhistory.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "work_history_transaction")
public class WorkHistoryTransaction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 268870749754336868L;
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="status")
	private String status;
	
	@OneToOne
	@JoinColumn(name="request_queue_id")
	private RequestQueue requestQueue;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="change_date")
	private Date changeDate;
	
	@ManyToOne
	@JoinColumn(name="requestor_company_hr_id")
	private User requestorCompanyHr;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public RequestQueue getRequestQueue() {
		return requestQueue;
	}

	public void setRequestQueue(RequestQueue requestQueue) {
		this.requestQueue = requestQueue;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}

	public User getRequestorCompanyHr() {
		return requestorCompanyHr;
	}

	public void setRequestorCompanyHr(User requestorCompanyHr) {
		this.requestorCompanyHr = requestorCompanyHr;
	}
}
