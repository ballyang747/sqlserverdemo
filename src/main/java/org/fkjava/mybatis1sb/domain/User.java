package org.fkjava.mybatis1sb.domain;

import java.io.Serializable;

public class User implements Serializable{

	private int id ;
	private String loginname ;
	private String username ;
	private String password;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public User(String loginname, String username, String password) {
		super();
		this.loginname = loginname;
		this.username = username;
		this.password = password;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getLoginname() {
		return loginname;
	}


	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", loginname=" + loginname + ", username=" + username + ", password=" + password
				+ "]";
	}
	
	
	
}
