package com.infosys.fs.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
	
	private String userId;
	
	private String name;
	
	private String creditScore;
	
	public String getCreditScore() {
		return creditScore;
	}
	
	public void setCreditScore(String creditScore) {
		this.creditScore = creditScore;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
