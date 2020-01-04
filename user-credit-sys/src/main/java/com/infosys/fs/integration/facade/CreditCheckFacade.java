package com.infosys.fs.integration.facade;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.infosys.fs.config.APIContext;
import com.infosys.fs.config.CustomRestTemplate;
import com.infosys.fs.exception.BadRequestException;
import com.infosys.fs.exception.ExternalSystemUnavailableException;
import com.infosys.fs.exception.InternalServerErrorException;
import com.infosys.fs.exception.NotFoundException;
import com.infosys.fs.model.APIResponseView;
import com.infosys.fs.model.UserCreditResponse;

@Service
public class CreditCheckFacade {
	
	@Value("${user.credit.check.response.url}")
	private String userCreditCheckResponseUrl;
	
	@Autowired
	RestTemplate restTemplate;
	
	public ResponseEntity<APIResponseView> invoke(APIContext apiContext, UserCreditResponse userCreditResponse)
			throws BadRequestException, NotFoundException, InternalServerErrorException, ExternalSystemUnavailableException {
		
		return CustomRestTemplate.invokeRestAPI(userCreditCheckResponseUrl, HttpMethod.POST, APIResponseView.class, null,
				apiContext.getHeaderParams(), userCreditResponse, Arrays.asList(MediaType.APPLICATION_JSON), restTemplate);
	}
	
}
