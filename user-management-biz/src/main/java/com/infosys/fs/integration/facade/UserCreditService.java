package com.infosys.fs.integration.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.fs.config.APIContext;
import com.infosys.fs.exception.APIException.Severity;
import com.infosys.fs.exception.BadRequestException;
import com.infosys.fs.exception.ExternalSystemUnavailableException;
import com.infosys.fs.exception.InternalServerErrorException;
import com.infosys.fs.exception.NotFoundException;
import com.infosys.fs.model.UserCreditRequest;

@Service
public class UserCreditService {
	
	@Autowired
	private UserCreditFacade userCreditFacade;
	
	public void processCreditCheckRequest(APIContext apiContext, UserCreditRequest userCreditRequest)
			throws ExternalSystemUnavailableException, InternalServerErrorException {
		
		try {
			userCreditFacade.invoke(apiContext, userCreditRequest);
		} catch (BadRequestException | NotFoundException | InternalServerErrorException e) {
			throw new InternalServerErrorException("500", Severity.ERROR, "Internal Server ");
		}
	}
	
}
