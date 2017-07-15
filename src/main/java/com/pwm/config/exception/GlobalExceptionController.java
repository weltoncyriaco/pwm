package com.pwm.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(InvalidPassWordException.class)
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	public @ResponseBody ExceptionResult handleCustomException(InvalidPassWordException ex) {
		return new ExceptionResult(ex.getMessage());
	} 
}
