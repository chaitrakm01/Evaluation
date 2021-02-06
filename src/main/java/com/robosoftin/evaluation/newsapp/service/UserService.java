package com.robosoftin.evaluation.newsapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robosoftin.evaluation.newsapp.common.Constants;
import com.robosoftin.evaluation.newsapp.common.Utils;
import com.robosoftin.evaluation.newsapp.dto.request.UserRequestDto;
import com.robosoftin.evaluation.newsapp.dto.response.BaseResponse;
import com.robosoftin.evaluation.newsapp.model.ApplicationUser;
import com.robosoftin.evaluation.newsapp.repository.ApplicationUserRepository;

@Service
public class UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	ApplicationUserRepository userRepository;

	// private BCryptPasswordEncoder bCryptPasswordEncoder;

	public BaseResponse saveUser(UserRequestDto user) {
		BaseResponse response = new BaseResponse();
		ApplicationUser userModel = null;
		try {
			// String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
			userModel = userRepository.findByUsername(user.getName());
			if (userModel != null) {
				response.setStatusMessage("User has already registered");
				response.setStatusCode(Constants.FAILURE_STATUS_CODE);

			} else {
				userModel = new ApplicationUser();

				userModel.setUsername(user.getName());
				userModel.setPassword(user.getPassword());
				userModel.setEmail(user.getEmail());
				userModel.setMobileNumber(user.getMobileNumber());
				String token = Utils.autoGenRefNumber();
				userRepository.save(userModel);
				response.setAuthToken(token);
				response.setStatusMessage(Constants.SUCCESS_MESSAGE);
				response.setStatusCode(Constants.SUCCESS_STATUS_CODE);

			}

		} catch (Exception e) {
			logger.info("Exception while save User info" + e.getMessage());
			response.setStatusMessage(Constants.FAILURE_MESSAGE);
			response.setStatusCode(Constants.FAILURE_STATUS_CODE);

		}
		return response;
	}

	public BaseResponse login(UserRequestDto user) {
		BaseResponse response = new BaseResponse();
		ApplicationUser userModel = new ApplicationUser();
		try {
			// String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
			userModel = userRepository.findByUsername(user.getName());
			if (userModel != null) {
				if (user.getPassword().equals(userModel.getPassword())) {
					response.setStatusMessage("Valid user");
					response.setStatusCode(Constants.SUCCESS_STATUS_CODE);
				}

			} else {
				response.setStatusMessage("User does not exist");
				response.setStatusCode(Constants.FAILURE_STATUS_CODE);
			}

		} catch (Exception e) {
			logger.info("Exception while save User info" + e.getMessage());
			response.setStatusMessage(Constants.FAILURE_MESSAGE);
			response.setStatusCode(Constants.FAILURE_STATUS_CODE);

		}
		return response;
	}
}
