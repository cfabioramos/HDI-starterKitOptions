package com.hdi.integration.starterKitOptions.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hdi.integration.starterKitOptions.controller.common.ApiErrorResponse;
import com.hdi.integration.starterKitOptions.controller.common.EnumExceptionCode;
import com.hdi.integration.starterKitOptions.dto.StarterKitOptions;
import com.hdi.integration.starterKitOptions.service.StarterKitOptionsService;
import com.progress.open4gl.Open4GLException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/insurancepolicy/{idInsurancePolicy}")
@Api("InsurancePolicy Start Kit Options")
public class StarterKitOptionsController {

    private static final Logger log = LoggerFactory.getLogger(StarterKitOptionsController.class);

    private StarterKitOptionsService service;

    private final HttpServletRequest request;

    private final ObjectMapper objectMapper;

    @org.springframework.beans.factory.annotation.Autowired
    public StarterKitOptionsController(
            ObjectMapper objectMapper, HttpServletRequest request, StarterKitOptionsService service) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.service = service;
    }

    @ApiOperation(value = "Send Start Kit Options")
    @GetMapping(value = "/starterKitOptions", produces = {"application/json"})
    public ResponseEntity<?> getStarterKitOptions(
            @ApiParam(value = "Company ID", required = true) @RequestHeader(value = "X-Company-Id", required = true) String xCompanyId,
            @ApiParam(value = "Application ID", required = true) @RequestHeader(value = "X-Application-Id", required = true) String xApplicationId,
            @ApiParam(value = "User ID", required = true) @RequestHeader(value = "X-User-Id", required = true) String xUserId,
            @ApiParam(value = "Insurance policy ID", required = true) @PathVariable("idInsurancePolicy") String idInsurancePolicy)
            throws Open4GLException, IOException {

        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            // return this.service.getStarterKitOptions(idInsurancePolicy);
            return new ResponseEntity<List<StarterKitOptions>>(objectMapper.readValue("[ {  \"flagReason\" : true,  \"description\" : \"description\",  \"id\" : 0}, {  \"flagReason\" : true,  \"description\" : \"description\",  \"id\" : 0} ]", List.class), HttpStatus.OK);
        }

        return new ResponseEntity<>(
                new ApiErrorResponse(EnumExceptionCode.DATA_INVALID, "You must accept \"application/json\"", null),
                HttpStatus.BAD_REQUEST);
    }
}
