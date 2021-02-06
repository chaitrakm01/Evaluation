package com.robosoftin.evaluation.newsapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "application_user")
public class ApplicationUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fldid")
	private long id;

	@Column(name = "fldusername")
	private String username;

	@Column(name = "fldpassword")
	private String password;

	@Column(name = "fldemail")
	private String email;

	@Column(name = "fldmobilenumber")
	private String mobileNumber;
	
	@Column(name = "fldunique_userid")
	private String uniqueUserId;
	
	@Column(name = "fldpreffered_language")
	private String prefferedLanguage;

	public long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUniqueUserId() {
		return uniqueUserId;
	}

	public void setUniqueUserId(String uniqueUserId) {
		this.uniqueUserId = uniqueUserId;
	}

	public String getPrefferedLanguage() {
		return prefferedLanguage;
	}

	public void setPrefferedLanguage(String prefferedLanguage) {
		this.prefferedLanguage = prefferedLanguage;
	}
}
