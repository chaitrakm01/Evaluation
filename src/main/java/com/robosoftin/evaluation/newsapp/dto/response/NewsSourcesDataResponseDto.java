package com.robosoftin.evaluation.newsapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsSourcesDataResponseDto {

	private List<NewsSourcesResponseDto> sources = null;
}