package com.example.its.web.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.its.domain.auth.User.Authority;
import com.example.its.web.Validation.UniqueUsername;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
public class UserForm {
	
	@NotBlank
	@UniqueUsername
	private String username;
	
	@NotBlank
	@Size(min=12, max = 128)
	private String password;
	
	@NotBlank
	private Authority authority;

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

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}
	
	

}
