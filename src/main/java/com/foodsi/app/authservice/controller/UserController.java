package com.foodsi.app.authservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodsi.app.authservice.dto.CommonResDto;
import com.foodsi.app.authservice.dto.UserDto;
import com.foodsi.app.authservice.exception.UserNotFoundException;
import com.foodsi.app.authservice.model.UserModel;
import com.foodsi.app.authservice.service.UserService;
import com.foodsi.app.authservice.util.CommonUtil;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "user")
public class UserController {
	
	@Autowired
	private CommonUtil commonUtil;
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "test")
	public String test() {
		return "hello";
	}
	
	@PostMapping(value="register")
	public ResponseEntity<CommonResDto> register(
			@Valid @RequestBody UserModel user,
			BindingResult result) {
		CommonResDto msg;
		if(result.hasErrors()) {
			msg = commonUtil.buildFieldErrors(result.getFieldErrors());
		}
		else {
			msg=userService.register(user);			
		}
		if(msg.getCode()=="400") {
			return new ResponseEntity<CommonResDto>(
					msg, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<CommonResDto>(
				msg, HttpStatus.CREATED);
	}
	
	@GetMapping(path = "get/{username}")
	public ResponseEntity<UserDto> getUser(@PathVariable String username) throws UserNotFoundException{
		UserDto user = userService.getUserByUserName(username);
		return new ResponseEntity<UserDto>(user,HttpStatus.OK);
	}
	 

}
