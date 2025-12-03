package com.Icwd.user.service.services.exceptions;


public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException() {
		super("Resource not found!!");
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
