package com.registration.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.registration.beans.UserDetails;
import com.registration.exception.AccountExistException;
import com.registration.response.RegResponse;
import com.registration.service.UserService;

@RestController
@RequestMapping(value = "/reg/api/v1", produces = "application/json")
public class RegistrationController {
	@Autowired
	UserService userService;
	public static final Logger LOG = LoggerFactory.getLogger(RegistrationController.class);

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public RegResponse register(@Valid @RequestBody UserDetails userDetails) throws AccountExistException {
		return userService.register(userDetails);
	}
}
