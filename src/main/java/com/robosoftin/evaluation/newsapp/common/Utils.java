package com.robosoftin.evaluation.newsapp.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.NoArgGenerator;

public class Utils {
	public static final String TIME_FORMAT = "YYYYMMddHHmmss";

	public static String generateToken() {
		String token = "";
		try {
			NoArgGenerator timeBasedGenerator = Generators.timeBasedGenerator();
			token = timeBasedGenerator.generate().toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return token;
	}

	public static String autoGenRefNumber() {
		long miliSeconds = System.currentTimeMillis();
		StringBuilder autoGenNum = new StringBuilder();
		autoGenNum.append(getCurrentFullTime(miliSeconds));
		return autoGenNum.toString();
	}

	public static String getCurrentFullTime(long miliSeconds) {
		return new SimpleDateFormat(TIME_FORMAT).format(new Date(miliSeconds));
	}
}
