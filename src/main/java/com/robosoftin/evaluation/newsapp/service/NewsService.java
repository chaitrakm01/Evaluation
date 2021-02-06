package com.robosoftin.evaluation.newsapp.service;

import com.robosoftin.evaluation.newsapp.dto.request.NewsSourcesRequestDto;
import com.robosoftin.evaluation.newsapp.dto.response.GenericServerResponse;

import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface NewsService {
	ResponseEntity<GenericServerResponse> getLanguageList();

	ResponseEntity<GenericServerResponse> getNewsSourcesList(NewsSourcesRequestDto newsSourcesRequestDto)
			throws IOException;

}
