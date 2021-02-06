package com.robosoftin.evaluation.newsapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.robosoftin.evaluation.newsapp.common.Constants;
import com.robosoftin.evaluation.newsapp.common.ReqValResult;
import com.robosoftin.evaluation.newsapp.common.Validation;
import com.robosoftin.evaluation.newsapp.dto.request.UserRequestDto;
import com.robosoftin.evaluation.newsapp.dto.response.BaseResponse;
import com.robosoftin.evaluation.newsapp.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public BaseResponse userSignup(@RequestBody UserRequestDto inRequestDTO) {
		BaseResponse response = new BaseResponse();
		try {
			ReqValResult reqValResult = new Validation().validateSignupRequest(inRequestDTO);
			if (!reqValResult.isValidated()) {
				logger.info("signup validation error : " + reqValResult.getStatusMessage());
				response.setStatusMessage(Constants.FAILURE_MESSAGE);
				response.setStatusCode(Constants.FAILURE_STATUS_CODE);
				return response;

			}
			response = userService.saveUser(inRequestDTO);
		} catch (Exception e) {
			logger.info("Exception getappdetails : " + e.getMessage());
			response.setStatusCode(Constants.FAILURE_STATUS_CODE);
		}
		return response;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public BaseResponse userLogin(@RequestBody UserRequestDto inRequestDTO) {
		BaseResponse response = new BaseResponse();
		try {

			response = userService.login(inRequestDTO);
		} catch (Exception e) {
			logger.info("Exception getappdetails : " + e.getMessage());
			response.setStatusCode(Constants.FAILURE_STATUS_CODE);
		}
		return response;
	}
}