package com.robosoftin.evaluation.newsapp.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "project.evaluation")
@Data
public class AppSettingConfig {

	private String newsBaseUrl;
	private String newsApiKey;

	public String getNewsBaseUrl() {
		return newsBaseUrl;
	}

	public void setNewsBaseUrl(String newsBaseUrl) {
		this.newsBaseUrl = newsBaseUrl;
	}

	public String getNewsApiKey() {
		return newsApiKey;
	}

	public void setNewsApiKey(String newsApiKey) {
		this.newsApiKey = newsApiKey;
	}
}