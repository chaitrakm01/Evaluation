package com.robosoftin.evaluation.newsapp.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.robosoftin.evaluation.newsapp.dto.request.UserRequestDto;
import com.robosoftin.evaluation.newsapp.exception.CommonException;

public class Validation {

	public static boolean validateUserName(String userName) {
		// validating username: Only alphanumeric and underscore is allowed for user
		// name and underscore at beg and end also
		Pattern p = Pattern.compile("^[a-zA-Z0-9_]*$");
		Matcher m = p.matcher(userName);
		boolean b = m.matches();
		return b;

	}

	public static boolean validateMobileNumber(String PATTERN, String mobileNumber) {
		Pattern pattern = Pattern.compile(PATTERN);
		Matcher matcher = pattern.matcher(mobileNumber);
		return matcher.matches();

	}

	public ReqValResult validateSignupRequest(UserRequestDto request) throws CommonException {
		ReqValResult result = new ReqValResult();
		try {
			if (request.getName() == null || request.getName().trim().isEmpty() || request.getEmail() == null
					|| request.getEmail().trim().isEmpty() || request.getMobileNumber() == null
					|| request.getMobileNumber().trim().isEmpty()) {
				result.setStatusMessage("Required fields are empty");
				return result;
			}
			result.setStatusCode(Constants.SUCCESS_STATUS_CODE);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CommonException("Error while validating request");
		}
		return result;

	}

	
}
