package com.infosys.fs.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infosys.fs.dao.repository.UserRepository;
import com.infosys.fs.exception.APIException.Severity;
import com.infosys.fs.exception.ExternalSystemUnavailableException;
import com.infosys.fs.exception.NotFoundException;
import com.infosys.fs.model.User;
import com.infosys.fs.model.UserCreditRequest;

@Repository
public class UserDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserDao.class);
	
	@Autowired
	private UserRepository userRepository;
	
	public String getCreditScore(UserCreditRequest userCreditRequest)
			throws NotFoundException, ExternalSystemUnavailableException {
		
		LOGGER.info("Finding user for id : {}", userCreditRequest.getId());
		try {
			User user = userRepository.findByUserId(userCreditRequest.getId());
			
			if (user != null) {
				return user.getCreditScore();
			} else {
				return "NOT_FOUND";
			}
		} catch (Exception e) {
			throw new ExternalSystemUnavailableException("551", Severity.ERROR, "Unable to connect to DB");
		}
		
	}
	
}
