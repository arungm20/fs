package com.infosys.fs.mapper;

import com.infosys.fs.model.UserCreditRequest;
import com.infosys.fs.model.UserCreditResponse;

public class CreditCheckResponseMapper {
	
	public static UserCreditResponse map(UserCreditRequest userCreditRequest, String creditScore) {
		
		UserCreditResponse userCreditResponse = new UserCreditResponse();
		userCreditResponse.setId(userCreditRequest.getId());
		userCreditResponse.setName(userCreditRequest.getName());
		userCreditResponse.setScore(creditScore);
		
		return userCreditResponse;
	}
	
}
