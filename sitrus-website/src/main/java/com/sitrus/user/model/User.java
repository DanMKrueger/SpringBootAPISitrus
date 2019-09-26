package com.sitrus.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="users", schema="sitrususers")
public class User {


	@Id
	private int id;
	@Column(name="user_name")
	private String user_name;
	@Column(name="user_password")
	private String user_password;
	@Column(name="first_name")
	private String first_name;
	@Column(name="last_name")
	private String last_name;
	@Column(name="email")
	private String email;
	@Column(name="zip")
	private String zip;
	@Column(name="user_type")
	private String user_type;

	public User(String username, String userPassword, String firstName, String lastName, String email, String zip,
			String userType) {
		super();
		this.user_name = username;
		this.user_password = userPassword;
		this.first_name = firstName;
		this.last_name = lastName;
		this.email = email;
		this.zip = zip;
		this.user_type = userType;
	}
	
	public User() {
		super();
		this.user_name = "";
		this.user_password = "";
		this.first_name = "";
		this.last_name = "";
		this.email = "";
		this.zip = "";
		this.user_type = "";
		
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + user_name + ", userPassword=" + user_password + ", firstName="
				+ first_name + ", lastName=" + last_name + ", email=" + email + ", zip=" + zip + ", userType=" + user_type
				+ "]";
	}

	public int getId() {
		return id;
	}
	
	public String getUsername() {
		return user_name;
	}

	public void setUsername(String username) {
		this.user_name = username;
	}

	public String getUserPassword() {
		return user_password;
	}

	public void setUserPassword(String userPassword) {
		this.user_password = userPassword;
	}

	public String getFirstName() {
		return first_name;
	}

	public void setFirstName(String firstName) {
		this.first_name = firstName;
	}

	public String getLastName() {
		return last_name;
	}

	public void setLastName(String lastName) {
		this.last_name = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getUserType() {
		return user_type;
	}

	public void setUserType(String userType) {
		this.user_type = userType;
	}

	

}
