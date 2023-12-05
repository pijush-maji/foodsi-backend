package com.foodsi.app.authservice.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomExceptionResponse {

	private String msg;
	private LocalDateTime timestamp;
}
