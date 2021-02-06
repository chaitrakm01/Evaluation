package com.robosoftin.evaluation.newsapp.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewsSourcesData {

	@JsonProperty("status")
	private String status;
	@JsonProperty("sources")
	private List<NewsSources> sources = null;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<NewsSources> getSources() {
		return sources;
	}

	public void setSources(List<NewsSources> sources) {
		this.sources = sources;
	}
}
