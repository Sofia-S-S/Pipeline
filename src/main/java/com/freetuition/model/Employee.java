package com.freetuition.model;

public class Employee {
	
	private int id;
	private String firstName;
	private String lastName;
	private String company;
	private String position;
	private int managerId;
	private String email;
	private long contact;
	private String address;
	
	public Employee() {}

	public Employee(String firstName, String lastName, String company, String position, int managerId, String email,
			long contact, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
		this.position = position;
		this.managerId = managerId;
		this.email = email;
		this.contact = contact;
		this.address = address;
	}

	public Employee(int id, String firstName, String lastName, String company, String position, int managerId,
			String email, long contact, String address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
		this.position = position;
		this.managerId = managerId;
		this.email = email;
		this.contact = contact;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", company=" + company
				+ ", position=" + position + ", managerId=" + managerId + ", email=" + email + ", contact=" + contact
				+ ", address=" + address + "]";
	}
	
	

}
