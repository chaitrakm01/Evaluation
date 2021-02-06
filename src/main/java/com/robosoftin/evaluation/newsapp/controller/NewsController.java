package com.robosoftin.evaluation.newsapp.controller;

import com.robosoftin.evaluation.newsapp.dto.request.NewsSourcesRequestDto;
import com.robosoftin.evaluation.newsapp.dto.response.GenericServerResponse;
import com.robosoftin.evaluation.newsapp.service.NewsService;

import lombok.extern.log4j.Log4j2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(value = "/api/v1/news")
@Log4j2
public class NewsController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private NewsService newsService;

	/**
	 * Method to list all the supported languges to the user
	 * 
	 * @return
	 */

	@GetMapping(value = "/languageList")
	public ResponseEntity<GenericServerResponse> getLanguageList() {
		return newsService.getLanguageList();
	}

	/**
	 * Method to get list of available news sources to the user
	 * 
	 * @return
	 */

	@PostMapping(value = "/sources")
	public ResponseEntity<GenericServerResponse> getNewsSourcesList(
			@RequestBody NewsSourcesRequestDto newsSourcesRequestDto) throws IOException {
		logger.debug("NewsController  :getPublicKey() execution started");
		return newsService.getNewsSourcesList(newsSourcesRequestDto);
	}

}
