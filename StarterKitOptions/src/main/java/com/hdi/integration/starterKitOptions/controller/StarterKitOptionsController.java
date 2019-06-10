package com.hdi.integration.StarterKitOptions.controller;

import com.hdi.integration.insurancePolicyDetails.service.InsurancePolicyDetailsService;
import com.progress.open4gl.Open4GLException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(value = "/insurancepolicy")
@Api("Insurance Policy Domain Services")
public class InsurancePolicyDetailsController {

	@Autowired
	private InsurancePolicyDetailsService service;

	@ApiOperation(value= "Add New Legal")
	@GetMapping(value = "/{idInsurancePolicy}", produces = {"application/json"})
	public ResponseEntity<?> getInsurancePolicyDetails(
            @ApiParam(value = "Company ID", required = true) @RequestHeader(value = "X-Company-Id", required = true) String xCompanyId,
            @ApiParam(value = "Application ID", required = true) @RequestHeader(value = "X-Application-Id", required = true) String xApplicationId,
            @ApiParam(value = "User ID", required = true) @RequestHeader(value = "X-User-Id", required = true) String xUserId,
            @ApiParam(value = "Policy ID", required = true) @PathVariable("idInsurancePolicy") String idInsurancePolicy)
			throws Open4GLException, IOException {

		this.service.getInsurancePolicyDetails(idInsurancePolicy);

		return new ResponseEntity<>(null, HttpStatus.OK);
	}
}
