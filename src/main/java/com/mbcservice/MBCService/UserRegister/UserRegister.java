package com.mbcservice.MBCService.UserRegister;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserRegister {
	
	@NotBlank(message = "Khong Duoc De Trong")
	@Size(min = 8, message = "Toi thieu 8 ky tu")
	private String username;
	
	
	@NotBlank(message = "Khong Duoc De Trong")
	@Pattern(regexp = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$\"",
			 message = "The password has eight characters including one uppercase letter, one lowercase letter, and one number or special character")
	private String password;
	
	@NotBlank(message = "Khong Duoc De Trong")
	private String firstname;
	
	@NotBlank(message = "Khong Duoc De Trong")
	private String lastname;
	
	@NotBlank(message = "Khong Duoc De Trong")
	@Email(message = "Email Khong hop le")
	private String email;
	
	public UserRegister() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserRegister(String username, String password, String firstname, String lastname,
			String email) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
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
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
