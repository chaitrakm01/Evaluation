package com.robosoftin.evaluation.newsapp.exception;

import org.springframework.http.HttpStatus;

import com.robosoftin.evaluation.newsapp.dto.response.ResultInfo;


public class RestTemplateTimeOutException extends CustomizedException {

	public RestTemplateTimeOutException(String errorCode, String errorMsg) {
		this.resultInfo = new ResultInfo(errorCode, errorMsg);
		this.status = HttpStatus.OK;
	}
}