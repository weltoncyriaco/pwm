package com.pwm.config.exception;

public class InvalidPassWordException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	
	public InvalidPassWordException() {
		super("Senha Invalida", null, false, false);
	}
	
}
