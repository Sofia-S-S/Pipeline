package com.freetuition.model;

import java.util.Date;

public class RequestRejected {

	private int requestId;
	private String reason;
	private int managerId;
	private Date date;
	
	public RequestRejected () {}

	public RequestRejected(int requestId, String reason, int managerId, Date date) {
		super();
		this.requestId = requestId;
		this.reason = reason;
		this.managerId = managerId;
		this.date = date;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
