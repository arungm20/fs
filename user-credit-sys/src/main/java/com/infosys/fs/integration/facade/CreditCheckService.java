package com.infosys.fs.integration.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.fs.config.APIContext;
import com.infosys.fs.exception.BadRequestException;
import com.infosys.fs.exception.ExternalSystemUnavailableException;
import com.infosys.fs.exception.InternalServerErrorException;
import com.infosys.fs.exception.NotFoundException;
import com.infosys.fs.model.UserCreditResponse;

@Service
public class CreditCheckService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CreditCheckService.class);
	
	@Autowired
	private CreditCheckFacade creditCheckFacade;
	
	public void sendCreditCheckResponse(APIContext apiContext, UserCreditResponse userCreditResponse) {
		
		try {
			creditCheckFacade.invoke(apiContext, userCreditResponse);
		} catch (BadRequestException e) {
			LOGGER.info("BadRequest in sending Response {}", e);
		} catch (NotFoundException e) {
			LOGGER.info("NotFoundException in sending Response {}", e);
		} catch (InternalServerErrorException e) {
			LOGGER.info("InternalServerErrorException in sending Response {}", e);
		} catch (ExternalSystemUnavailableException e) {
			LOGGER.info("ExternalSystemUnavailableException in sending Response {}", e);
		}
	}
}
