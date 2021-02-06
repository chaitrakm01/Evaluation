package com.robosoftin.evaluation.newsapp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsSourcesRequestDto {

	private String uniqueUserId;
	private String category;
	private String country;
	public String getUniqueUserId() {
		return uniqueUserId;
	}
	public void setUniqueUserId(String uniqueUserId) {
		this.uniqueUserId = uniqueUserId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
