package com.tyss.movie_management.exception;

public class MovieNotFoundException extends RuntimeException{
	
	public MovieNotFoundException(String message) {
		super(message);
	}

}
