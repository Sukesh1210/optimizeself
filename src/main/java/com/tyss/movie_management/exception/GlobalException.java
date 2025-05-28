package com.tyss.movie_management.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tyss.movie_management.response.ErrorResponse;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(MovieNotFoundException.class)
	public ResponseEntity<ErrorResponse> movieNotFound(MovieNotFoundException e){
		return ResponseEntity.ofNullable(ErrorResponse.builder()
				.message("Movie Not Found")
				.status(HttpStatus.NOT_FOUND)
				.timestamp(LocalDateTime.now()).build());
	}
}
