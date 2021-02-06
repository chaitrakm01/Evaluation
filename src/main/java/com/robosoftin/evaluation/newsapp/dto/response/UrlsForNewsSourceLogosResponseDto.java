package com.robosoftin.evaluation.newsapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UrlsForNewsSourceLogosResponseDto {

	private String small;
	private String medium;
	private String large;
}