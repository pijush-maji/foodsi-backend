package com.foodsi.app.authservice.model;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "User")
public class UserModel {

	@NotEmpty(message = "First name is empty!")
	private String firstName;
	@NotEmpty(message = "Last name is empty!")
	private String lastName;
	@NotEmpty(message = "Email is empty!")
	private String email;
	@NotEmpty(message = "Country code is empty!")
	private String countryCode;
	@NotEmpty(message = "Mobile No is empty!")
	private String mobileNo;
	@NotEmpty(message = "Username is empty!")
	private String userName;
	@NotEmpty(message = "Password is empty!")
	private String password;
}
