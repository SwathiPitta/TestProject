package com.registration.controller.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.registration.constant.RegErrorMessage;
import com.registration.exception.AccountExistException;
import com.registration.response.ErrorResponse;
import com.registration.response.RegResponse;

@ControllerAdvice(basePackages={"com.registration.controller"})
public class RegistrationContollerAdvice {
	private static final Logger LOG= LoggerFactory.getLogger(RegistrationContollerAdvice.class);
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	@ExceptionHandler(AccountExistException.class)
	@ResponseBody
	private RegResponse AccountExistException(AccountExistException ex){
		RegResponse resp= new RegResponse();
		LOG.error(ex.getMessage(), ex);
		ErrorResponse errorResp= generateErrorResponse(RegErrorMessage.ACCOUNT_ALREADY_EXISTS);
		resp.setError(errorResp);
		return resp;
	}

	private ErrorResponse generateErrorResponse(String accountAlreadyExists) {
		return null;
	}
}
