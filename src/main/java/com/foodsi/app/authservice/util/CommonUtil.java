package com.foodsi.app.authservice.util;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;

import com.foodsi.app.authservice.dto.CommonResDto;

@Component
public class CommonUtil {

	
	public CommonResDto buildFieldErrors(List<FieldError> errors) {
		StringBuilder e = new StringBuilder();
		for(FieldError f : errors) {
			e.append(f.getDefaultMessage()+",");
		}
		return new CommonResDto(e.toString().substring(0, e.length()-1), "400");
	}
}
