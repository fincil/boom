package com.fincil.boom.services.model.user;

import javax.persistence.Entity;

import com.fincil.boom.services.model.abstractModel.GenericModel;

@Entity
public class User extends GenericModel {
	
	private static final long serialVersionUID = 1L;
	
	private String password;
	private String realname;
	private String email;
	private String phone;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
