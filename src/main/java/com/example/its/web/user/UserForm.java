package com.example.its.web.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.its.domain.auth.User.Authority;
import com.example.its.web.Validation.UniqueUsername;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserForm {

	@NotBlank
	@UniqueUsername
	private String username;
	
	@NotBlank
	private String email;
	
	@NotBlank
	@Size(min=12, max = 128)
	private String password;
	
	private String authority;

}
