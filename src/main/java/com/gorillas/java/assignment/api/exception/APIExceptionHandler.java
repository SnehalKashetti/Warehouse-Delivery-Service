package com.gorillas.java.assignment.api.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class APIExceptionHandler {

	@ExceptionHandler(value = { DeliveryApiRequestException.class })
	public ResponseEntity<Object> handleApiRequestException(DeliveryApiRequestException e) {
		HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		ExceptionResponse responseException = new ExceptionResponse(e.getMessage(), badRequest,
				ZonedDateTime.now(ZoneId.of("Z")));
		return new ResponseEntity<>(responseException, badRequest);
	}

}
