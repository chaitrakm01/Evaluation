package com.robosoftin.evaluation.newsapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.robosoftin.evaluation.newsapp.common.Constants;
import com.robosoftin.evaluation.newsapp.exception.RestTemplateTimeOutException;

import java.net.URI;
import java.util.Collections;

@Component
public class GenericRestTemplateUtil {

	@Autowired
	private RestTemplate restTemplate;

	public ResponseEntity<String> genericRestTemplateForGetWithQueryParameter(URI uri) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<String>(headers);
			ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
			return response;
		} catch (Exception e) {
			throw new RestTemplateTimeOutException(Constants.TIMEOUT_EXCEPTION, Constants.TIME_OUT);
		}
	}
}
