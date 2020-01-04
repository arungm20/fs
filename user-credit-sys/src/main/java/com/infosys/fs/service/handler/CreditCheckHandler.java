package com.infosys.fs.service.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.infosys.fs.config.APIContext;
import com.infosys.fs.dao.UserDao;
import com.infosys.fs.exception.ExternalSystemUnavailableException;
import com.infosys.fs.exception.NotFoundException;
import com.infosys.fs.integration.facade.CreditCheckService;
import com.infosys.fs.mapper.CreditCheckResponseMapper;
import com.infosys.fs.model.UserCreditRequest;

@Service
public class CreditCheckHandler {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CreditCheckService creditCheckService;
	
	@Async
	public ResponseEntity<Void> checkCredit(APIContext apiContext, UserCreditRequest userCreditRequest)
			throws NotFoundException, ExternalSystemUnavailableException, InterruptedException {
		
		Thread.sleep(5000);
		String creditScore = userDao.getCreditScore(userCreditRequest);
		
		creditCheckService.sendCreditCheckResponse(apiContext,
				CreditCheckResponseMapper.map(userCreditRequest, creditScore));
		return null;
		
	}
	
}
