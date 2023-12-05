package com.foodsi.app.authservice.service;

import org.springframework.stereotype.Service;

import com.foodsi.app.authservice.dto.CommonResDto;
import com.foodsi.app.authservice.dto.UserDto;
import com.foodsi.app.authservice.exception.UserNotFoundException;
import com.foodsi.app.authservice.model.UserModel;
import com.foodsi.app.authservice.repository.UserRepo;

@Service
public class UserService {
	
	
	private final UserRepo userRepo;
	
	public UserService(UserRepo userRepo) {
		this.userRepo=userRepo;
	}

	public CommonResDto register(UserModel user) {
		CommonResDto msg;
		if(userRepo.findByUserName(user.getUserName())!=null) {
			msg = new CommonResDto("User name is taken!", "400");
		}else {			
			UserModel savedUser = userRepo.save(user);
			if(savedUser==null)
				msg = new CommonResDto("Error Creating user", "400");
			else
				msg = new CommonResDto("Created", "201");
		}
		return msg;
	}
	
	public UserDto getUserByUserName(String username) throws UserNotFoundException {
		UserModel user = userRepo.findByUserName(username);
		if(user==null) {
			throw new UserNotFoundException("User not found with username "+username);
		}else {
			UserDto userDto = new UserDto(
					user.getFirstName(),
					user.getLastName(),
					user.getEmail(),
					user.getMobileNo(),
					user.getUserName());
			return userDto;
					
		}
	}
}
