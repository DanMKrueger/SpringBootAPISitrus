package com.sitrus.user.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name="users")
public class User {

	
	@Id 
	private int id;
	private String username;
	private String userPassword;
	private String firstName;
	private String lastName;
	private String email;
	private String zip;
	private String userType;

	public User(String username, String userPassword, String firstName, String lastName, String email, String zip,
			String userType) {
		super();
		this.username = username;
		this.userPassword = userPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.zip = zip;
		this.userType = userType;
	}
	
	public User() {
		super();
		this.username = "";
		this.userPassword = "";
		this.firstName = "";
		this.lastName = "";
		this.email = "";
		this.zip = "";
		this.userType = "";
		
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", userPassword=" + userPassword + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", zip=" + zip + ", userType=" + userType
				+ "]";
	}

	public int getId() {
		return id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
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
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	

}
