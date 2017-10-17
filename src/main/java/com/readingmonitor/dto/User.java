package com.readingmonitor.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="user_details")
public class User {
	
	@Id
	private int id;
	@NotNull
	@Size(min=3, max=20)
	private String username;
	@NotNull
	@Email
	private String email;
	@NotNull
	@Size(min=3, max=20)
	@Column(name="first_name")
	private String firstName;
	@NotNull
	@Size(min=3, max=20)
	@Column(name="last_name")
	private String lastName;
	@NotNull
	@Size(min=10,max=10)
	private String phone;
	@NotNull
	@Size(min=3, max=20)
	@Column(name="pwd")
	private String password; 
	
	public User(){
		
	}
	
	public User(int id,String username, String email, String firstname, String lastname,
			String phone) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.firstName = firstname;
		this.lastName = lastname;
		this.phone = phone;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
