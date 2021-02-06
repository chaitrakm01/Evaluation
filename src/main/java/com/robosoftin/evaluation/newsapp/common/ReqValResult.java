package com.robosoftin.evaluation.newsapp.common;

public class ReqValResult {
	private int statusCode;
	private String statusMessage;

	public ReqValResult() {
		this.statusCode = 1;
	}

	public boolean isValidated() {
		if (Constants.SUCCESS_STATUS_CODE == statusCode) {
			return true;
		}
		return false;
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

}
