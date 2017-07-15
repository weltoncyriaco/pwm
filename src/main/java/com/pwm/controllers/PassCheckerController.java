package com.pwm.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pwm.beans.MeterResultBean;
import com.pwm.services.PassCheckerService;

@RestController
@RequestMapping(value = "/meter")
public class PassCheckerController {

	@Autowired
	private PassCheckerService service; 
	
	@GetMapping(path = "/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody MeterResultBean test(@PathVariable("password") String password) {
		return service.checarSenha(password);
	}
}
