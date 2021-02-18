package com.freetuition.model;

import java.util.Date;

public class Request {
	
	private int requestId;
	private int employeeId;
	private String school;
	private String course;
	private String type;
	private double price;
	private String status;
	private Date graduation;
	private String receipt;
	private Date date;
	
	public Request( ) {}

	public Request(int employeeId, String school, String course, String type, double price, String status,
			Date graduation, String receipt, Date date) {
		super();
		this.employeeId = employeeId;
		this.school = school;
		this.course = course;
		this.type = type;
		this.price = price;
		this.status = status;
		this.graduation = graduation;
		this.receipt = receipt;
		this.date = date;
	}

	public Request(int requestId, int employeeId, String school, String course, String type, double price,
			String status, Date graduation, String receipt, Date date) {
		super();
		this.requestId = requestId;
		this.employeeId = employeeId;
		this.school = school;
		this.course = course;
		this.type = type;
		this.price = price;
		this.status = status;
		this.graduation = graduation;
		this.receipt = receipt;
		this.date = date;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getGraduation() {
		return graduation;
	}

	public void setGraduation(Date graduation) {
		this.graduation = graduation;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
