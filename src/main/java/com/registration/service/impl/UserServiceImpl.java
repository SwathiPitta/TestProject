package com.registration.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.registration.beans.UserDetails;
import com.registration.constant.RegErrorMessage;
import com.registration.exception.AccountExistException;
import com.registration.repository.UserRepo;
import com.registration.response.RegResponse;
import com.registration.response.RegResult;
import com.registration.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	public static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	UserRepo userRepo;

	@Override
	public RegResponse register(UserDetails userDetails) throws AccountExistException {
		RegResponse response = new RegResponse();
		RegResult result = new RegResult();
		checkEmailId(userDetails.getEmailId());
		userDetails.setPassword(userDetails.getPassword());
		UserDetails resp = userRepo.save(userDetails);
		if (!(resp.getEmailId().equals(null))) {
			result.setMessage("Registred Successfully");
		}
		response.setResult(result);
		return response;
	}

	private void checkEmailId(String emailId) throws AccountExistException {
		boolean response = userRepo.existsByEmailId(emailId);
		if (response) {
			throw new AccountExistException(RegErrorMessage.ACCOUNT_ALREADY_EXISTS);
		}

	}

}
