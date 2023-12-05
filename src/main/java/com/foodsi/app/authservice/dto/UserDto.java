package com.foodsi.app.authservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
	
	private String firstName;
	private String lastName;
	private String email;
	private String mobileNo;
	private String username;
}
