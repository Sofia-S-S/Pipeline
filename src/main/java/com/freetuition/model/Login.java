package com.freetuition.model;

public class Login {
	
	private int id;
	private String login;
	private String password;
	
	public Login() {}
	
	

	public Login(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public Login(int id, String login, String password) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
