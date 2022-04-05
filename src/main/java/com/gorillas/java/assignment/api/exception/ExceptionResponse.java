package com.gorillas.java.assignment.api.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class ExceptionResponse {
	@Getter
	private final String message;
	@Getter
	private final HttpStatus httpStatus;
	@Getter
	private final ZonedDateTime timestamp;

}
