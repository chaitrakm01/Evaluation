package com.robosoftin.evaluation.newsapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "language")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LanguageModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fldid")
	private int id;
	@Column(name = "fldlanguage_name")
	private String languageName;
	@Column(name = "fldlanguage_code")
	private String languageCode;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLanguageName() {
		return languageName;
	}
	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
	public String getLanguageCode() {
		return languageCode;
	}
	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}
}