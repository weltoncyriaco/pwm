package com.pwm.config.exception;

public class ExceptionResult {

	private String message;

	public ExceptionResult(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
