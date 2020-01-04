package com.infosys.fs.service.handler;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.infosys.fs.config.APIContext;
import com.infosys.fs.exception.ExternalSystemUnavailableException;
import com.infosys.fs.exception.InternalServerErrorException;
import com.infosys.fs.integration.facade.UserCreditService;
import com.infosys.fs.model.APIResponseView;
import com.infosys.fs.model.UserCreditRequest;
import com.infosys.fs.model.UserCreditResponse;
import com.infosys.fs.routing.ResourceRouter;

@Service
public class UserCreditHandler {
	
	@Autowired
	private UserCreditService userCreditService;
	
	private Map<String, String> creditCheckMap = new HashMap<>();
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserCreditHandler.class);
	
	public ResponseEntity<Object> checkCredit(APIContext apiContext, UserCreditRequest userCreditRequest)
			throws ExternalSystemUnavailableException, InternalServerErrorException {
		
		if (creditCheckMap.get(userCreditRequest.getId()) != null) {
			APIResponseView apiResponseView = new APIResponseView();
			apiResponseView.setStatusCode("409");
			apiResponseView.setStatusDescription("ALREADY QUEUED");
			return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponseView);
		}
		
		userCreditService.processCreditCheckRequest(apiContext, userCreditRequest);
		creditCheckMap.put(userCreditRequest.getId(), "PROCESSING");
		APIResponseView apiResponseView = new APIResponseView();
		apiResponseView.setStatusCode("202");
		apiResponseView.setStatusDescription("ACCEPTED");
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(apiResponseView);
	}
	
	public ResponseEntity<Object> checkCreditResponse(APIContext apiContext, UserCreditResponse creditCheckResponse) {
		
		if (creditCheckMap.get(creditCheckResponse.getId()) != null) {
			
			creditCheckMap.remove(creditCheckResponse.getId());
			LOGGER.info("Received Response for id : {} with credit Score : {}", creditCheckResponse.getId(),
					creditCheckResponse.getScore());
			
			APIResponseView apiResponseView = new APIResponseView();
			apiResponseView.setStatusCode("200");
			apiResponseView.setStatusDescription("OK");
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(apiResponseView);
			// Process Further business Logic
			
		}
		APIResponseView apiResponseView = new APIResponseView();
		apiResponseView.setStatusCode("404");
		apiResponseView.setStatusDescription("NOT_FOUND");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponseView);
		
	}
	
}
