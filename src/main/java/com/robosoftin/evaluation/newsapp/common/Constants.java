package com.robosoftin.evaluation.newsapp.common;

import com.robosoftin.evaluation.newsapp.dto.response.ResultInfo;

public class Constants {

	public final static int SUCCESS_STATUS_CODE = 0;
	public final static int FAILURE_STATUS_CODE = 1;
	public final static int VALID_TOKEN_STATUS_CODE = 0;
	public final static int INVALID_TOKEN_STATUS_CODE = 2;

	public final static String SUCCESS_MESSAGE = "success";
	public final static String FAILURE_MESSAGE = "failure";
	public static final String NEWS_SOURCES = "v1/sources";
	public static final String NEWS_ARTICLES = "v1/articles";
	public static final String QUESTION_MARK = "?";	
	public static final String LANGUAGE = "language=";
	public static final String CATEGORY = "category=";
	public static final String COUNTRY = "country=";
	
	//error
	public static final String TIMEOUT_EXCEPTION = "-1000";
	public static final String TIME_OUT = "Failed to fetch the data";
	private static final String GENERAL_EXCEPTION_CODE = "-1001";
	public static final ResultInfo GENERAL_EXCEPTION = new ResultInfo(GENERAL_EXCEPTION_CODE, Constants.INTERNAL_SERVER_ERROR);
	static final String INTERNAL_SERVER_ERROR = "Internal server Error";






	

}
