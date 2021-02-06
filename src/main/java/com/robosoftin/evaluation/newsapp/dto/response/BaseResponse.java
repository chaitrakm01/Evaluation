package com.robosoftin.evaluation.newsapp.dto.response;

import com.robosoftin.evaluation.newsapp.common.Constants;

public class BaseResponse {

	private int statusCode;
	private String statusMessage;
	private String authToken;

	public BaseResponse() {
		super();
		this.statusCode = Constants.FAILURE_STATUS_CODE;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	@Override
	public String toString() {
		return "BaseResponse [statusCode=" + statusCode + ", statusMessage=" + statusMessage + "]";
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

}
