
package com.infosys.fs.routing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.infosys.fs.config.APIContext;
import com.infosys.fs.model.APIResponseView;
import com.infosys.fs.model.UserCreditRequest;
import com.infosys.fs.service.handler.CreditCheckHandler;

@Service
public class ResourceRouter {
	
	@Autowired
	private CreditCheckHandler creditCheckHandler;
	
	public ResponseEntity<Object> process(APIContext apiContext, UserCreditRequest userCreditRequest) throws Exception {
		
		
		creditCheckHandler.checkCredit(apiContext, userCreditRequest);
		APIResponseView apiResponseView = new APIResponseView();
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(apiResponseView);
		
	}
	
}
