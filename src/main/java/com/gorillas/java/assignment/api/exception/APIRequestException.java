package com.gorillas.java.assignment.api.exception;

@SuppressWarnings("serial")
public class APIRequestException extends RuntimeException {

	public APIRequestException(String message) {
		super(message);
	}

	public APIRequestException(String message, Throwable cause) {
		super(message, cause);
	}

}
