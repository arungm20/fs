/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.10).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.infosys.fs.rest;

import com.infosys.fs.model.UserCreditRequest;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-02T10:58:13.754+05:30")

@Api(value = "v1", description = "the v1 API")
public interface V1Api {

    @ApiOperation(value = "API to Check the Credit Score of the User", nickname = "creditCheck", notes = "Check Credit Score of the user", tags={ "User Credit", })
    @ApiResponses(value = { 
        @ApiResponse(code = 202, message = "Accepted"),
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 500, message = "Internal Server Error"),
        @ApiResponse(code = 551, message = "Unable to reach Downstream system"),
        @ApiResponse(code = 552, message = "External System Connection error") })
    @RequestMapping(value = "/v1/check-credit",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Object> creditCheck(@ApiParam(value = "Indicates the time at which request was created. Date format: ISO-8601 format (yyyy-MM-dd'T'HH:mm:ss'Z' or yyyy-MM-dd'T'HH:mm:ss±hh:mm)" ,required=true) @RequestHeader(value="MWMD-requestTimestamp", required=true) String mwMDRequestTimestamp,@ApiParam(value = "Identifies the name of the business activity for the message being exchanged. For MYUPC channel, this should be provided as \"CustomerCare\"" ,required=true) @RequestHeader(value="MWMD-activityName", required=true) String mwMDActivityName,@ApiParam(value = "RequestID is a unique identifier that is unique for a single request/response message and will be used to map log and error message to consumer’s request." ,required=true) @RequestHeader(value="MWMD-requestID", required=true) String mwMDRequestID,@ApiParam(value = "Represents  Resource entity" ,required=true )  @Valid @RequestBody UserCreditRequest userCreditCheckRequest) throws Exception;

}