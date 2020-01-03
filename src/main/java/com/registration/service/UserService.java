package com.registration.service;

import org.springframework.stereotype.Service;

import com.registration.beans.UserDetails;
import com.registration.exception.AccountExistException;
import com.registration.response.RegResponse;

@Service
public interface UserService {

	RegResponse register(UserDetails userDetails) throws AccountExistException;

}
