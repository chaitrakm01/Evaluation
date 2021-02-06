package com.robosoftin.evaluation.newsapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.robosoftin.evaluation.newsapp.common.Constants;
import com.robosoftin.evaluation.newsapp.config.AppSettingConfig;
import com.robosoftin.evaluation.newsapp.config.GenericRestTemplateUtil;
import com.robosoftin.evaluation.newsapp.controller.UserController;
import com.robosoftin.evaluation.newsapp.dto.request.NewsSourcesRequestDto;
import com.robosoftin.evaluation.newsapp.dto.response.GenericServerResponse;
import com.robosoftin.evaluation.newsapp.dto.response.LanguageListResponseDto;
import com.robosoftin.evaluation.newsapp.dto.response.NewsSourcesData;
import com.robosoftin.evaluation.newsapp.dto.response.NewsSourcesDataResponseDto;
import com.robosoftin.evaluation.newsapp.model.ApplicationUser;
import com.robosoftin.evaluation.newsapp.model.LanguageModel;
import com.robosoftin.evaluation.newsapp.repository.ApplicationUserRepository;
import com.robosoftin.evaluation.newsapp.repository.LanguageModelRepository;

import lombok.extern.log4j.Log4j2;

import org.apache.tomcat.util.bcel.classfile.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class NewsServiceImpl implements NewsService {
	private static final Logger logger = LoggerFactory.getLogger(NewsServiceImpl.class);

	@Autowired
	private LanguageModelRepository languageModelRepository;
	@Autowired
	private ApplicationUserRepository userRepository;
	@Autowired
	private AppSettingConfig appSettingConfig;
	@Autowired
	private GenericRestTemplateUtil genericRestTemplateUtil;

	/**
	 * Method to list all supported language Data.
	 *
	 * @return
	 */
	@Override
	public ResponseEntity<GenericServerResponse> getLanguageList() {
		List<LanguageModel> languageModelList = languageModelRepository.findAll();
		List<LanguageListResponseDto> languageListResponseDtoList = languageModelList.stream().map(languageModel -> {
			LanguageListResponseDto languageListResponseDto = new LanguageListResponseDto();
			languageListResponseDto.setLanguageCode(languageModel.getLanguageCode());
			languageListResponseDto.setLanguageName(languageModel.getLanguageName());
			return languageListResponseDto;
		}).collect(Collectors.toList());
		return generateSuccessResponse(languageListResponseDtoList);
	}

	/**
	 * Method to fetch news sources from news API.
	 * 
	 * @param newsSourcesRequestDto
	 * @return
	 * @throws IOException
	 */
	@Override
	public ResponseEntity<GenericServerResponse> getNewsSourcesList(NewsSourcesRequestDto newsSourcesRequestDto)
			throws IOException {

		try {
			String languageCode = null;
			if (newsSourcesRequestDto.getUniqueUserId() == null
					|| newsSourcesRequestDto.getUniqueUserId().trim().isEmpty())
				languageCode = "";
			else {
				ApplicationUser userModel = userRepository.findByUniqueUserId(newsSourcesRequestDto.getUniqueUserId());
				if (userModel == null)
					languageCode = "";
				else {
					languageCode = userModel.getPrefferedLanguage();
				}
			}
			ResponseEntity<String> response = getNewsSourcesFromNewsAPI(newsSourcesRequestDto, languageCode);
			return validateAndReturnSourceResponse(response);
		} catch (Exception e) {
			return generateSuccessResponse(Collections.emptyList());
		}
	}

	/**
	 * Method to validate news source API response & generate API response
	 * 
	 * @param response
	 * @return
	 * @throws IOException
	 */
	private ResponseEntity<GenericServerResponse> validateAndReturnSourceResponse(ResponseEntity<String> response)
			throws IOException {

		if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
			NewsSourcesData newsSourcesData = new ObjectMapper().readValue(response.getBody(), NewsSourcesData.class);
			if (newsSourcesData.getStatus().equalsIgnoreCase("ok")) {
				NewsSourcesDataResponseDto newsSourcesDataResponseDto = new NewsSourcesDataResponseDto();
				BeanUtils.copyProperties(newsSourcesData, newsSourcesDataResponseDto);
				return generateSuccessResponse(newsSourcesDataResponseDto);
			}
		}
		return generateSuccessResponse(Collections.emptyList());
	}

	/**
	 * Method to generate News sources API URI
	 * 
	 * @param newsSourcesRequestDto
	 * @param languageCode
	 * @return
	 */
	private ResponseEntity<String> getNewsSourcesFromNewsAPI(NewsSourcesRequestDto newsSourcesRequestDto,
			String languageCode) {

		String url = appSettingConfig.getNewsBaseUrl() + Constants.NEWS_SOURCES + Constants.QUESTION_MARK;
		if (languageCode.trim().isEmpty()) {
			// Ignore if it's empty
		} else {
			url = url + Constants.LANGUAGE + languageCode;
		}
		if (newsSourcesRequestDto.getCategory() == null || newsSourcesRequestDto.getCategory().trim().isEmpty()) {
			// Ignore if it's empty or null
		} else {
			url = url + "&" + Constants.CATEGORY + newsSourcesRequestDto.getCategory().trim();
		}
		if (newsSourcesRequestDto.getCountry() == null || newsSourcesRequestDto.getCountry().trim().isEmpty()) {
			// Ignore if it's empty or null
		} else {
			url = url + "&" + Constants.COUNTRY + newsSourcesRequestDto.getCountry().trim();
		}
		URI uri = UriComponentsBuilder.fromUriString(url).build().toUri();
		logger.info("Generated URI===>" + uri);
		ResponseEntity<String> response = genericRestTemplateUtil.genericRestTemplateForGetWithQueryParameter(uri);
		logger.info("Response of Sources API===>" + response);
		return response;
	}

	/**
	 * Method to generate the success Response
	 *
	 * @param responseObject
	 * @return
	 */
	public ResponseEntity<GenericServerResponse> generateSuccessResponse(Object responseObject) {
		GenericServerResponse serverResponse = new GenericServerResponse("0", Constants.SUCCESS_MESSAGE,
				responseObject);
		return new ResponseEntity<>(serverResponse, HttpStatus.OK);
	}

}
