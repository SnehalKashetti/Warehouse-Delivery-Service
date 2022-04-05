package com.gorillas.java.assignment.api.exception;

@SuppressWarnings("serial")
public class DeliveryApiRequestException extends RuntimeException {

	public DeliveryApiRequestException(String message, Throwable cause) {
		super(message, cause);
	}

	public DeliveryApiRequestException(String message) {
		super(message);
	}

}
